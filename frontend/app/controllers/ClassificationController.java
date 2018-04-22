package controllers;

import UIForm.ApiForm;
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

public class ClassificationController extends Controller implements WSBodyReadables, WSBodyWritables{

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
   
    @Inject
    public ClassificationController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result classficationView () {
        String username = session().get("username");
        String userType = session().get("type");
        return ok(views.html.topicsClassification.render(username, userType));
    }

    public CompletionStage<Result> getTopics() {
        //DynamicForm form = formFactory.form().bindFromRequest();
        int userId = Integer.parseInt(session().get("id"));
        //String userId = session().get("id");
        WSRequest request = ws.url(urlService.getTopicsURL(userId));  //Integer.parseInt
        return request.get()
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }

}
