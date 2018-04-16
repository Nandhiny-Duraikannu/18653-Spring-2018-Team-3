package controllers;

import UIForm.ApiForm;
import UIForm.Mashup;
import com.fasterxml.jackson.databind.node.ArrayNode;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
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
public class SubmitApiController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private List<ApiForm> apiForm = new ArrayList<>();
    private List<Mashup> mashForm =new ArrayList<>();



    @Inject
    public SubmitApiController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result apiFormView () {
        String username = session().get("username");
        return ok(views.html.submitApi.render(username));
    }

    public Result searchApiView () {
        String username = session().get("username");
        return ok(views.html.searchApiMashup.render(username, apiForm, mashForm));
    }

    public CompletionStage<Result> displayApiView (int id) {
        String username = session().get("username");
        String url = urlService.getApiURL(id);
        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                ApiForm apiForm = new ApiForm();

                JsonNode body = Json.parse(r.getBody().toString());

                apiForm.setId(body.findPath("id").asInt());
                apiForm.setName(body.findPath("name").asText());
                apiForm.setType(body.findPath("type").asText());
                apiForm.setHomepage(body.findPath("homepage").asText());
                apiForm.setEndpoint(body.findPath("endpoint").asText());
                apiForm.setVersion(body.findPath("version").asText());
                apiForm.setScope(body.findPath("scope").asText());
                apiForm.setDescription(body.findPath("description").asText());
                apiForm.setEmail(body.findPath("email").asText());

                return ok(views.html.apiDetail.render(username, apiForm, apiForm.getComments()));
            } else {
                return badRequest("Error while getting API");
            }
        });
    }

    public CompletionStage<Result> submitApi () {
        Form<ApiForm> apiForm = formFactory.form(ApiForm.class).bindFromRequest();
        ApiForm apiData = apiForm.get();
        apiData.setUser_id(session().get("id"));
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
        String username = session().get("username");
        DynamicForm form = formFactory.form().bindFromRequest();
        String url = urlService.searchURL() + "?searchParam=" + form.get("searchParam")+"&type="+form.get("type")+"&userId="+session().get("id");

        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {

                if(form.get("type").equals("api")) {
                    List<ApiForm> res = generateApiFromJson(r);
                    return ok(views.html.searchApiMashup.render(username, res, mashForm));
                }
                else if (form.get("type").equals("mashup"))
                {
                    List<Mashup> res = generateMashupFromJson(r);
                    return ok(views.html.searchApiMashup.render(username, apiForm, res));
                }
                else{
                    return badRequest("Error searching object type");
                }
            } else {
                return badRequest("Error while searching ");
            }
        });
    }

    private List<ApiForm> generateApiFromJson (WSResponse r) {
        JsonNode jsonNode = Json.parse(r.getBody());
        List<ApiForm> apis = new ArrayList<>();
        for (JsonNode api : jsonNode) {
            ApiForm newApi = new ApiForm();
            newApi.setId(api.get("id").asInt());
            newApi.setName(api.get("name").asText());
            newApi.setDescription(api.get("description").asText());
            newApi.setStatus(api.get("following").asText());

            apis.add(newApi);
        }
        return apis;
    }

    private List<Mashup> generateMashupFromJson (WSResponse r) {
        JsonNode jsonNode = Json.parse(r.getBody());
        List<Mashup> mashups = new ArrayList<Mashup>();
        for (JsonNode mashup : jsonNode) {
            Mashup newMashup = new Mashup();
            newMashup.setId(mashup.get("id").asInt());

            newMashup.setName(mashup.get("name").asText());
            newMashup.setDescription(mashup.get("description").asText());
            newMashup.setStatus(mashup.get("following").asText());
            mashups.add(newMashup);
        }
        return mashups;
    }

    public Result addComment (int id) {
        return ok ();
    }
}
