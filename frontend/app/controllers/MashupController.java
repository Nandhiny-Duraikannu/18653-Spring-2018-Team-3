package controllers;

import UIForm.ApiForm;
import UIForm.Mashup;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
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
    private final HttpExecutionContext httpExecutionContext;
    private List<String> apiIds;
    private Form<Mashup> mashupForm;
    private String[] blankApiIds = {"0"};


    @Inject
    public MashupController(WSClient ws, FormFactory formFactory, HttpExecutionContext ec) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
        this.httpExecutionContext = ec;
    }

    public CompletionStage<Result> submitMashupView () {
        WSRequest request = ws.url(urlService.getApiPerState());
        return request.get()
                .thenApplyAsync((WSResponse r) -> {
                    JsonNode approvedApis = r.asJson().findPath("approvedApis");
                    System.out.println(approvedApis.toString());
                    return ok(views.html.mashupForm.render(approvedApis));
                }, httpExecutionContext.current());
    }

    private List<Mashup> generateMashupFromJson (WSResponse x) {
        JsonNode jsonNode = Json.parse(x.getBody());
        List<Mashup> mashups = new ArrayList<Mashup>();
        for (JsonNode mashup : jsonNode) {
            Mashup newMashup = new Mashup();
            newMashup.setName(mashup.get("name").asText());
            newMashup.setDescription(mashup.get("description").asText());
            mashups.add(newMashup);
        }
        return mashups;
    }

    public CompletionStage<Result> mashupListView () {
        String username = session().get("username");
        String userType = session().get("type");
        WSRequest request = ws.url(urlService.getAllMashupsURL());
        return request.get()
        .thenApply((WSResponse r) -> {
            List<Mashup> res = generateMashupFromJson(r);
            return ok(views.html.mashupList.render(username, userType, res, ""));
        });
    }

    public CompletionStage<Result> searchMashups() {
        String username = session().get("username");
        String userType = session().get("type");
        DynamicForm form = formFactory.form().bindFromRequest();
        String query = form.get("query");
        WSRequest request = ws.url(urlService.searchMashupsURL(query));
        return request.get()
        .thenApply((WSResponse r) -> {
            List<Mashup> res = generateMashupFromJson(r);
            return ok(views.html.mashupList.render(username, userType, res, query));

        });

    }

    public CompletionStage<Result> submitMashup () {
        Form<Mashup> mashupForm = formFactory.form(Mashup.class).bindFromRequest();
        Mashup mashup = mashupForm.get();
        mashup.setUser_id(session().get("id"));
        String typeCheck = mashup.getType();

        if(typeCheck.equals("api")) {
            mashup.setApiIds(blankApiIds);
        }

        System.out.println(Json.toJson(mashup));

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.submitMashupURL());
        return request
        .post(Json.toJson(mashup))
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return redirect(routes.HomeController.homeView());
            } else {
                return badRequest("Error while trying to submit mashup");
            }
        });
    }
}
