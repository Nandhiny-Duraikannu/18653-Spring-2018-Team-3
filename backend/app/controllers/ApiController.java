package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import enums.NotificationType;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import services.apiFilter.ApiStateCriteria;
import services.apiFilter.ApprovedCriteria;
import services.apiFilter.PendingCriteria;
import services.apiStates.ApiState;
import services.apiStates.ApprovedApi;
import services.apiStates.PendingApi;
import services.factories.AbstractFactory;
import services.factories.ApiFactory;

import services.command.*;

import models.*;
import DAO.*;
import services.factories.FactoryProducer;
import services.submissions.SubmissionCache;


import javax.inject.Inject;
import java.util.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApiController extends Controller {
    private final FormFactory formFactory;

    private MashupDAO mashupDAO;
    private ApiDAO apiDAO;
    private UserDAO userDAO;
    private LogMessageDAO logMessageDAO;

    private AbstractFactory apiFactory;

    @Inject
    public ApiController(FormFactory formFactory) {
        this.formFactory = formFactory;

        this.mashupDAO = new MashupDAO();
        this.apiDAO = new ApiDAO();
        this.userDAO = new UserDAO();
        this.logMessageDAO = new LogMessageDAO();

        this.apiFactory = FactoryProducer.getFactory("api");
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result submitApi() {
        JsonNode apiJson = request().body().asJson();
        String userId = apiJson.findPath("user_id").textValue();
        String apiType = apiJson.findPath("type").textValue();
        String name = apiJson.findPath("name").textValue();
        String homepage = apiJson.findPath("homepage").textValue();
        String endpoint = apiJson.findPath("endpoint").textValue();
        String version = apiJson.findPath("version").textValue();
        String scope = apiJson.findPath("scope").textValue();
        String description = apiJson.findPath("description").textValue();
        String email = apiJson.findPath("email").textValue();

        JsonNode apiIdsNode = apiJson.findPath("apiIds");

        List<Integer> apiIds = new ArrayList<>();
        for (JsonNode n: apiIdsNode) {
            apiIds.add(Integer.valueOf(n.textValue()));
        }

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));
        Api api = apiFactory.getApi(apiType, name, homepage, endpoint, version, scope, description, email, apiIds);
        ApiState apiState = new PendingApi();
        apiState.updateApiState(api);

        api.setUser(user);
        api.insert();

        logMessageDAO.writeSubmitApiLogMessage(user.getUsername(), name);

        return ok(api.toJson());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateApi () {
        JsonNode apiJson = request().body().asJson();
        int apiId = apiJson.findPath("apiId").intValue();
        apiDAO.approveApi(apiId);
        return ok();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result followApi() {
        JsonNode apiJson = request().body().asJson();
        String userId = apiJson.findPath("user_id").textValue();
        String apiID = apiJson.findPath("api_id").textValue();

        Api api = apiDAO.getById(Integer.valueOf(apiID));
        if (api == null) {
            return notFound("API Not Found.");
        }

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));
        if (user == null) {
            return notFound("User Not Found.");
        }

        api.notifyAllFollowers(NotificationType.FOLLOW_NOTIFICATION);
        api.addFollower(user);
        api.save();

        return ok();
    }

    public Result getAllApis () {
        List<JsonNode> apis = new ArrayList<>();
        List<Api> allApis = apiDAO.getAll();

        Iterator<Api> apiIterator = allApis.iterator();
        while(apiIterator.hasNext()) {
            apis.add(apiIterator.next().toJson());
        }

        return ok(Json.toJson(apis));
    }

    public Result getApisPerState () {

        ApiStateCriteria approvedApiCriteria = new ApprovedCriteria();
        ApiStateCriteria pendingApiCriteria = new PendingCriteria();

        List<JsonNode> jsonApprovedApis = new ArrayList<>();
        List<JsonNode> jsonPendingApis = new ArrayList<>();

        List<Api> allApis = apiDAO.getAll();
        List<Api> approvedApis = approvedApiCriteria.meetCriteria(allApis);
        List<Api> pendingApis = pendingApiCriteria.meetCriteria(allApis);

        Iterator<Api> approvedApiIterator = approvedApis.iterator();
        Iterator<Api> pendingApiIterator = pendingApis.iterator();
        while(approvedApiIterator.hasNext()) {
            Api approvedApi = approvedApiIterator.next();
            jsonApprovedApis.add(approvedApi.toJson());
        }
        while(pendingApiIterator.hasNext()) {
            Api pendingApi = pendingApiIterator.next();
            jsonPendingApis.add(pendingApi.toJson());
        }
        String result = "{\"approvedApis\": " + jsonApprovedApis + ", ";
        result += "\"pendingApis\": " + jsonPendingApis + "}";
        return ok(result);
    }

    public Result getAllFollowers() {
        DynamicForm form = formFactory.form().bindFromRequest();
        int userId = Integer.valueOf(form.get("userId"));
        List<Api> apis = apiDAO.searchAPIs(userId);

        List<JsonNode> apisJson = new ArrayList<>();
        Iterator<Api> iterator = apis.iterator();
        while (iterator.hasNext()) {
            apisJson.add(iterator.next().toJson());
        }
        return ok(Json.toJson(apisJson));
    }

    public Result searchApi() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchParam = form.get("searchParam");
        String userId = form.get("userId");
        String type = form.get("type");

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));
        if (user == null) {
            return notFound("User Not Found.");
        }
        List<Api> apis = apiDAO.searchAPIs(searchParam, type);
        List<JsonNode> apisJson = new ArrayList<>();
        Iterator<Api> apiIterator = apis.iterator();

        while(apiIterator.hasNext()) {
            Api api = apiIterator.next();
            ObjectNode apiJson = api.toJson();
            boolean isFollowing = user.isFollowingApi(api);
            apiJson.put("following", isFollowing ? "YES" : "NO");
            apisJson.add(apiJson);
        }

        logMessageDAO.writeSearchApiLogMessage(user.getUsername(), "\""+searchParam+"\"");
        return ok(Json.toJson(apisJson));
    }

    public Result getApiById (int id) {
        Api api = apiDAO.getApiById(id);

//        if (api != null)
//            logMessageDAO.writeViewApiLogMessage("someone", api.getName());

        return ok(api.toJson());
    }
}
