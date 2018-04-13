package controllers;

import DAO.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import services.ApiFactory;

import javax.inject.Inject;
import java.util.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApiController extends Controller {
    private final FormFactory formFactory;
    private MashupDAO mashupDAO = new MashupDAO();
    private ApiDAO apiDAO = new ApiDAO();
    private UserDAO userDAO = new UserDAO();
    private ApiFactory apiFactory = new ApiFactory();


    @Inject
    public ApiController(FormFactory formFactory) {
        this.formFactory = formFactory;
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
        Api api = apiFactory.createApi(apiType, name, homepage, endpoint, version, scope, description, email, apiIds);
        user.addApi(api);
        user.save();
        return ok(api.toJson());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result followApi() {
        JsonNode apiJson = request().body().asJson();
        String userId = apiJson.findPath("user_id").textValue();
        String apiID = apiJson.findPath("api_id").textValue();

        Api api = apiDAO.getById(Integer.valueOf(apiID));
        if (api == null)
            return notFound("API Not Found.");

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));
        if (user == null)
            return notFound("User Not Found.");

        api.notifyAllFollowers();
        api.addFollower(user);
        api.save();

        return ok();
    }

    public Result getAllApis () {
        List<JsonNode> apis = new ArrayList<>();
        for (Api api: apiDAO.getAll()) {
            apis.add(api.toJson());
        }
        return ok(Json.toJson(apis));
    }

    public Result getAllFollowers() {
        DynamicForm form = formFactory.form().bindFromRequest();
        int userId = Integer.valueOf(form.get("userId"));
        List<Api> apis = apiDAO.searchAPIs(userId);

        List<JsonNode> apisJson = new ArrayList<>();
        for (Api api: apis) {
            apisJson.add(api.toJson());
        }

        return ok(Json.toJson(apisJson));
    }

    public Result searchApi() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchParam = form.get("searchParam");
        String userId = form.get("userId");
        String type = form.get("type");

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));
        if (user == null)
            return notFound("User Not Found.");

        List<Api> apis = apiDAO.searchAPIs(searchParam, type);

        List<JsonNode> apisJson = new ArrayList<>();
        for (Api api: apis) {
            ObjectNode apiJson = api.toJson();
            boolean isFollowing = user.isFollowingApi(api);
            apiJson.put("following", isFollowing ? "YES" : "NO");
            apisJson.add(apiJson);
        }

        return ok(Json.toJson(apisJson));
    }

    public Result getApiById (int id) {
        Api api = apiDAO.getApiById(id);

        String apiCommentsJson = apiDAO.getCommentsForApi(id);
        String result = api.toJsonWithComments(apiCommentsJson);
        return ok(result);
    }
}
