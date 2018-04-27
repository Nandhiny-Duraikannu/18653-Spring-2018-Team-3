package controllers;

import UIForm.ApiForm;
import UIForm.Mashup;
import com.fasterxml.jackson.databind.node.ArrayNode;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.*;
import play.mvc.*;
import scala.util.parsing.json.JSONObject;
import services.BackendURLService;
import com.fasterxml.jackson.databind.JsonNode;

import UIForm.Comment;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApiController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private final HttpExecutionContext httpExecutionContext;

    private String[] blankApiIds = {"0"};

    @Inject
    public ApiController(WSClient ws, FormFactory formFactory, HttpExecutionContext ec) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
        this.httpExecutionContext = ec;
    }

    public Result searchApiView () {
        return ok(views.html.search.render(null));
    }

    public CompletionStage<Result> displayApiView (int id) {
        String username = session().get("username");
        String userType = session().get("type");
        String url = urlService.getApiURL(id);
        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                ApiForm apiForm = new ApiForm();

                JsonNode body = Json.parse(r.getBody());
                apiForm.setId(body.findPath("id").asInt());
                apiForm.setName(body.findPath("name").asText());
                apiForm.setType(body.findPath("type").asText());
                apiForm.setHomepage(body.findPath("homepage").asText());
                apiForm.setEndpoint(body.findPath("endpoint").asText());
                apiForm.setVersion(body.findPath("version").asText());
                apiForm.setScope(body.findPath("scope").asText());
                apiForm.setDescription(body.findPath("description").asText());
                apiForm.setUser_id(body.findPath("user").asText());

//                ArrayNode arr = (ArrayNode)comments;
//                Iterator<JsonNode> it = arr.iterator();
//
//                while (it.hasNext()) {
//                    JsonNode obj = it.next();
//                    Comment c = new Comment();
//                    c.setContent(obj.findPath("comment").asText());
//                    apiForm.addComment(c);
//                }
                return ok(views.html.apiDetail.render(username, userType, apiForm, apiForm.getComments()));
            } else {
                return badRequest("Error while getting API");
            }
        });
    }

    public CompletionStage<Result> submitView () {
        WSRequest request = ws.url(urlService.getApiPerState());
        return request.get()
                .thenApplyAsync((WSResponse r) -> {
                    JsonNode approvedApis = r.asJson().findPath("approvedApis");
                    return ok(views.html.submitForm.render(approvedApis));
                }, httpExecutionContext.current());
    }

    public CompletionStage<Result> submitApi () {
        Form<Mashup> mashupForm = formFactory.form(Mashup.class).bindFromRequest();
        Mashup mashup = mashupForm.get();
        mashup.setUser_id(session().get("id"));
        String typeCheck = mashup.getType();

        if(typeCheck.equals("api")) {
            mashup.setApiIds(blankApiIds);
        }

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

    public CompletionStage<Result> searchApis () {
        DynamicForm form = formFactory.form().bindFromRequest();
        String url = urlService.searchURL() + "?searchParam=" + form.get("searchParam")+"&type="+form.get("type")+"&userId="+session().get("id");

        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApplyAsync((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return ok(views.html.search.render(r.asJson()));
            } else {
                return badRequest("Error while searching ");
            }
        }, httpExecutionContext.current());
    }

    public Result addComment (int id) {
        return ok ();
    }
}
