package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.ws.*;
import play.mvc.Controller;
import play.mvc.Result;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class ApproveApiController extends Controller  implements WSBodyReadables, WSBodyWritables {

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private String showError = "";
    public static String accessToken;

    @Inject
    public ApproveApiController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result approveApiView() {
        String username = session().get("username");
        String userType = session().get("type");
        return ok(views.html.approveApi.render(username, userType));
    }

    public CompletionStage<Result> getApisPerState () {
        WSRequest request = ws.url(urlService.getApiPerState());
        return request
        .get()
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }

    public CompletionStage<Result> approveApi () {
        DynamicForm form = formFactory.form().bindFromRequest();
        int apiId = Integer.valueOf(form.get("apiId"));
        WSRequest request = ws.url(urlService.approveApiURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post("{\"apiId\": " + apiId + "}")
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }
}
