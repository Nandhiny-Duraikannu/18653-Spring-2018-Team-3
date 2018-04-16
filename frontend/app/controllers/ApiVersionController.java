package controllers;

import UIForm.ApiForm;
import UIForm.Mashup;
import com.fasterxml.jackson.databind.JsonNode;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class ApiVersionController extends Controller {

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private List<ApiForm> apiForm = new ArrayList<>();
    private List<Mashup> mashForm =new ArrayList<>();

    @Inject
    public ApiVersionController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public CompletionStage<Result> updateApi (int apiId) {
        Form<ApiForm> apiForm = formFactory.form(ApiForm.class).bindFromRequest();
        ApiForm api = apiForm.get();
        api.setId(apiId);

        WSRequest request = ws.url(urlService.updateApiUrl());
        return request
        .addHeader("Content-Type", "application/json")
        .post(Json.toJson(api))
        .thenApply((WSResponse r) -> {
            return redirect(routes.SubmitApiController.displayApiView(api.getId()));
        });
    }

    public Result allVersionsForApiView (int apiId) {
        String username = session().get("username");
        String userType = session().get("type");
        return ok(views.html.allVersionsOfApi.render(username, userType, apiId));
    }

    public CompletionStage<Result> allVersionsForApi (int apiId) {
        WSRequest request = ws.url(urlService.getVersionsForApiURL(apiId));
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }

    public CompletionStage<Result> updateApiView (int apiId) {
        String username = session().get("username");
        String userType = session().get("type");
        String url = urlService.getApiURL(apiId);
        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                ApiForm apiForm = new ApiForm();

                JsonNode body = Json.parse(r.getBody());
                apiForm.setId(apiId);
                apiForm.setName(body.findPath("name").asText());
                apiForm.setType(body.findPath("type").asText());
                apiForm.setHomepage(body.findPath("homepage").asText());
                apiForm.setEndpoint(body.findPath("endpoint").asText());
                apiForm.setVersion(body.findPath("version").asText());
                apiForm.setScope(body.findPath("scope").asText());
                apiForm.setDescription(body.findPath("description").asText());
                apiForm.setUser_id(body.findPath("user").asText());

                return ok(views.html.updateApi.render(username, userType, apiForm));
            } else {
                return badRequest("Error while getting API");
            }
        });
    }

}
