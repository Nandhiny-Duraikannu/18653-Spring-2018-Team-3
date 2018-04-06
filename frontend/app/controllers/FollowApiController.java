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

public class FollowApiController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private List<String> apiIds;
    private Form<ApiForm> apiForm;


    @Inject
    public FollowApiController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public CompletionStage<Result> followApi () {
        
        DynamicForm form = formFactory.form().bindFromRequest();
        String apiId = form.get("apiId");
        String userId = session().get("id");

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.followApiURL(apiId, userId));
        return request
        .post("followApi")
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return ok("Following API now");
            } else {
                System.out.println(r.getStatus());
                return badRequest("Error while trying to follow api/mashup");
            }
        });
    }


}
