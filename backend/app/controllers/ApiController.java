package controllers;

import DAO.*;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApiController extends Controller {
    private final FormFactory formFactory;

    private ApiDAO apiDAO = new ApiDAO();
    private UserDAO userDAO = new UserDAO();

    @Inject
    public ApiController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result submitApi() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String userId = form.get("user_id");
        String apiname = form.get("apiname");
        String apihomepage = form.get("apihomepage");
        String apiendpoint = form.get("apiendpoint");
        String version = form.get("version");
        String scope = form.get("scope");
        String apidescription = form.get("apidescription");
        String emailaddress = form.get("emailaddress");

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));

        Api api = apiDAO.addApi(user, apiname, apihomepage, apiendpoint, version, scope, apidescription, emailaddress);
        return ok(api.toJSON());
    }


    public Result getApi () {
        String allapi = apiDAO.getApi();
        return ok(allapi);
    }

    public Result searchApi () {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchParam = form.get("searchParam");
    
        List<Api> apis = apiDAO.searchAPIs(searchParam);

        List<JsonNode> apisJson = new ArrayList<>();
        for (Api api: apis) {
            apisJson.add(api.toJSONObj());
        }
        return ok(Json.toJson(apisJson));
    }
}
