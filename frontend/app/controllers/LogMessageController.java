package controllers;

import play.data.FormFactory;
import play.libs.ws.*;
import play.mvc.Controller;
import play.mvc.Result;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class LogMessageController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public LogMessageController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result logMessagesView() {
        String username = session().get("username");
        String userType = session().get("type");
        return ok(views.html.log.render(username, userType));
    }

    public CompletionStage<Result> getLogMessages() {
        WSRequest request = ws.url(urlService.getLogMessagesURL());
        return request
                .get()
                .thenApply((WSResponse r) -> {
                    return ok(r.getBody());
                });
    }
}
