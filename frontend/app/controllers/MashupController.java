package controllers;

import UIForm.Mashup;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.ws.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;
import play.twirl.api.Html;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class MashupController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private List<String> apiIds;
    private Form<Mashup> mashupForm;

    @Inject
    public MashupController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result submitMashupView () {
        return ok(views.html.mashupForm.render());
    }

    private List<Mashup> generateMashupFromJson (WSResponse r) {
        JsonNode jsonNode = Json.parse(r.getBody());
        List<Mashup> mashups = new ArrayList<Mashup>();
        for (JsonNode mashup : jsonNode) {
            Mashup newMashup = new Mashup();
            newMashup.setName(mashup.get("name").asText());
            newMashup.setDescription(mashup.get("description").asText());
            newMashup.setDescription(mashup.get("apiIds").asText());
            newMashup.setUser_id(mashup.get("id").asText());
            mashups.add(newMashup);
        }
        return mashups;
    }

    public CompletionStage<Result> mashupListView () {
        WSRequest request = ws.url(urlService.getAllMashupsURL());
        return request.get()
        .thenApply((WSResponse r) -> {
            List<Mashup> res = generateMashupFromJson(r);
            System.out.println(res.toString());
            return ok(views.html.mashupList.render(res, ""));
        });
    }

    public CompletionStage<Result> searchMashups() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String query = form.get("query");
        WSRequest request = ws.url(urlService.searchMashupsURL(query));
        return request.get()
        .thenApply((WSResponse r) -> {
            List<Mashup> res = generateMashupFromJson(r);
            return ok(views.html.mashupList.render(res, query));
        });
    }

    public CompletionStage<Result> submitMashup () {
        Form<Mashup> mashupForm = formFactory.form(Mashup.class).bindFromRequest();
        Mashup mashup = mashupForm.get();
        mashup.setUser_id(session().get("id"));
        String mashupJson = Json.toJson(mashup).toString();
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.submitMashupURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(mashupJson)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return redirect(routes.HomeController.homeView());
            } else {
                System.out.println(r.getStatus());
                return badRequest("Error while trying to submit mashup");
            }
        });
    }


}
