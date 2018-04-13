package controllers;

import UIForm.Mashup;
import UIForm.Message;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.Controller;
import play.mvc.Result;
import services.BackendURLService;

import javax.annotation.processing.Completion;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class MessageController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    public Result showMessageView () {
        String username = session().get("username");
        return ok(views.html.messages.render(username));
    }

    @Inject
    public MessageController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public CompletionStage<Result> getMessagesForUser () {
        int userId = Integer.valueOf(session().get("id"));
        WSRequest request = ws.url(urlService.getMessagesForUserURL(userId));
        return request
        .get()
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }

    public CompletionStage<Result> sendMessage () {
        int userId = Integer.valueOf(session().get("id"));
        Form<Message> messageForm = formFactory.form(Message.class).bindFromRequest();
        Message message = messageForm.get();
        message.setSender_id(userId);
        WSRequest request = ws.url(urlService.sendMessageURL());
        return request
        .post(Json.toJson(message))
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }

}
