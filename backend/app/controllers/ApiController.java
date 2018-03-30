package controllers;

import DAO.ApiDAO;
import models.Api;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApiController extends Controller {
    private final FormFactory formFactory;

    private ApiDAO apiDAO = new ApiDAO();

    @Inject
    public ApiController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result submitApi() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String apiname = form.get("apiname");
        String apihomepage = form.get("apihomepage");
        String apiendpoint = form.get("apiendpoint");
        String version = form.get("version");
        String scope = form.get("scope");
        String apidescription = form.get("apidescription");
        String emailaddress = form.get("emailaddress");


        Api api = apiDAO.addApi(apiname,apihomepage,apiendpoint,version,scope,apidescription,emailaddress);
        return ok(api.toJSON());
    }


    public Result getApi () {
        String allapi = apiDAO.getApi();
        return ok(allapi);
    }
}
