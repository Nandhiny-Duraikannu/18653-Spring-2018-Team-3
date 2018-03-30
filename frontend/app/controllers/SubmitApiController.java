package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.ws.*;
import play.mvc.*;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import com.fasterxml.jackson.databind.JsonNode;

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


    public CompletionStage<Result> submitapi () {
        DynamicForm form = formFactory.form().bindFromRequest();

        StringBuilder apiJSON = new StringBuilder();
        apiJSON.append("{");
        apiJSON.append("\"apiname\": \"").append(form.get("apiname")).append("\", ");
        apiJSON.append("\"apihomepage\": \"").append(form.get("apihomepage")).append("\", ");
        apiJSON.append("\"apiendpoint\": \"").append(form.get("apiendpoint")).append("\", ");
        apiJSON.append("\"version\": \"").append(form.get("version")).append("\", ");
        apiJSON.append("\"scope\": \"").append(form.get("scope")).append("\", ");
        apiJSON.append("\"apidescription\": \"").append(form.get("apidescription")).append("\", ");
     //   apiJSON.append("\"objecttype\": \"").append(form.get("objecttype")).append("\", ");
        apiJSON.append("\"emailaddress\": \"").append(form.get("emailaddress")).append("\"} ");


        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.submitApiURL());
        return request
                .addHeader("Content-Type", "application/json")
                .post(apiJSON.toString())
                .thenApply((WSResponse r) -> {
                    if (r.getStatus() == 200) {
                        return ok("submitted successfully");
                    } else {
                        return badRequest("Error while submitting API");
                    }
                });
    }
}
