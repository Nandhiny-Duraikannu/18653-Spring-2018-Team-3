package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.ws.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class MashupController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public MashupController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result submitMashupView () {
        return ok(views.html.mashupForm.render());
    }

    public Result mashupListView () {
        return ok(views.html.mashupList.render());
    }

    public CompletionStage<Result> getAllMashups() {
        WSRequest request = ws.url(urlService.getAllMashupsURL());
        return request.get()
        .thenApply((WSResponse r) -> {
            //JsonNode jsonNode = r.getBody(json());

            return ok(r.getBody());
        });
    }

    public CompletionStage<Result> searchMashups() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String query = form.get("query");

        WSRequest request = ws.url(urlService.searchMashupsURL(query));
        return request.get()
        .thenApply((WSResponse r) -> {
            //JsonNode jsonNode = r.getBody(json());

            return ok(r.getBody());
        });
    }

    public CompletionStage<Result> submitMashup () {
        DynamicForm form = formFactory.form().bindFromRequest();

        JsonNode mashupJson = Json.newObject()
                .put("username", session().get("username"))
                .put("name", form.get("name"))
                .put("url", form.get("url"))
                .put("description", form.get("description"));

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.submitMashupURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(mashupJson)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return redirect(routes.MashupController.mashupListView());
            } else {
                return badRequest("Error while trying to submit mashup");
            }
        });
    }
}
