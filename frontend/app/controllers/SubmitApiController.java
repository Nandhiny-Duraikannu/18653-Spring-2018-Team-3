package controllers;

import UIForm.ApiForm;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class SubmitApiController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public SubmitApiController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result apiFormView () {
        return ok(views.html.submitApi.render());
    }

    public Result searchApiView () { return ok(views.html.searchApis.render()); }

    public CompletionStage<Result> submitApi () {
        Form<ApiForm> apiForm = formFactory.form(ApiForm.class).bindFromRequest();
        ApiForm apiData = apiForm.get();
        apiData.setUser(session().get("username"));
        String apiJson = Json.toJson(apiData).toString();

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.submitApiURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(apiJson)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return redirect(routes.HomeController.homeView());
            } else {
                return badRequest("Error while submitting API");
            }
        });
    }

    public CompletionStage<Result> searchApis () {
        DynamicForm form = formFactory.form().bindFromRequest();
        String url = urlService.searchAPIURL() + "?searchParam=" + form.get("searchParam");
        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {

                return ok(r.getBody());
            } else {
                return badRequest("Error while searching for an API");
            }
        });
    }
}
