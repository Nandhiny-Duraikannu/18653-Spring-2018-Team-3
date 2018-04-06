package controllers;

import UIForm.ApiForm;
import UIForm.Mashup;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;
import services.BackendURLService;
import com.fasterxml.jackson.databind.JsonNode;

import javax.inject.Inject;
import java.util.ArrayList;
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
    private List<ApiForm> apiForm = new ArrayList<>();;
    private List<Mashup> mashForm =new ArrayList<>();;



    @Inject
    public SubmitApiController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result apiFormView () {
        return ok(views.html.submitApi.render());
    }

    public Result searchApiView () { return ok(views.html.searchApiMashup.render(apiForm,mashForm)); }

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
            System.out.println("r.getStatus():"+r.getStatus());
            System.out.println("request:"+r);
            if (r.getStatus() == 200) {
                return redirect(routes.HomeController.homeView());
            } else {
                return badRequest("Error while submitting API");
            }
        });
    }

    public CompletionStage<Result> searchApis () {
        DynamicForm form = formFactory.form().bindFromRequest();
        String url = urlService.searchURL() + "?searchParam=" + form.get("searchParam")+"&type="+form.get("type")+"&userId="+session().get("id");
        System.out.println("in api search"+url);
        // Post the json to create the user in the backend
        WSRequest request = ws.url(url);
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                if(form.get("type").equals("api")) {
                    System.out.println("search api success");
                    //   return ok(r.getBody());
                    List<ApiForm> res = generateApiFromJson(r);
                    return ok(views.html.searchApiMashup.render(res,mashForm));
                }
                else if (form.get("type").equals("mashup"))
                {
                    List<Mashup> res = generateMashupFromJson(r);
                    return ok(views.html.searchApiMashup.render(apiForm,res));


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
        List<ApiForm> apis = new ArrayList<ApiForm>();
        for (JsonNode api : jsonNode) {
            ApiForm newApi = new ApiForm();
            newApi.setName(api.get("name").asText());
            newApi.setDescription(api.get("description").asText());
            apis.add(newApi);
        }
        return apis;
    }

    private List<Mashup> generateMashupFromJson (WSResponse r) {
        JsonNode jsonNode = Json.parse(r.getBody());
        List<Mashup> mashups = new ArrayList<Mashup>();
        for (JsonNode mashup : jsonNode) {
            Mashup newMashup = new Mashup();
            newMashup.setName(mashup.get("name").asText());
            newMashup.setDescription(mashup.get("description").asText());
            mashups.add(newMashup);
        }
        return mashups;
    }


}
