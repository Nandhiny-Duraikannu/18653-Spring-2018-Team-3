package controllers;

import DAO.*;
import com.fasterxml.jackson.databind.JsonNode;
import forms.ApiForm;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
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
        Form<ApiForm> apiForm = formFactory.form(ApiForm.class).bindFromRequest();
        ApiForm apiData = apiForm.get();

        String username = apiData.getUser();
        String apiName = apiData.getApiname();
        String apiHomePage = apiData.getApihomepage();
        String apiEndpoint = apiData.getApiendpoint();
        String version = apiData.getVersion();
        String scope = apiData.getScope();
        String apiDescription = apiData.getApidescription();
        String emailAddress = apiData.getEmailaddress();

        User user = userDAO.getUserByUsername(username);

        Api api = apiDAO.addApi(user, apiName, apiHomePage, apiEndpoint, version, scope, apiDescription,
                emailAddress);
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
