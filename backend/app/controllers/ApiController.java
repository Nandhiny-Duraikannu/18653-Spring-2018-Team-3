package controllers;

import DAO.*;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import services.ApiFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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

    public Result getAllApis () {
        List<JsonNode> apis = new ArrayList<>();
        for (Api api: apiDAO.getAll()) {
            apis.add(api.toJson());
        }
        return ok(Json.toJson(apis));
    }

    public Result searchApi () {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchParam = form.get("searchParam");
        String type = form.get("type");
        System.out.println("type"+type);

        if (type.equals("api")) {
            List<Api> apis = apiDAO.searchAPIs(searchParam,type);

            List<JsonNode> apisJson = new ArrayList<>();
            for (Api api : apis) {
                apisJson.add(api.toJson());

                // TODO: test
                api.notifyAllFollowers();
            }
            return ok(Json.toJson(apisJson));
        }
        else
            {
                System.out.println("in mashup search");
                List<Mashup> mashups = mashupDAO.searchMashups(searchParam,type);

                List<JsonNode> mashupsJson = new ArrayList<>();
                for (Mashup mashup : mashups) {
                    mashupsJson.add(mashup.toJson());
                }
                return ok(Json.toJson(mashupsJson));

            }
    }
}
