package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;

import DAO.*;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class MessageController extends Controller {
    private final FormFactory formFactory;
    private ApiDAO apiDAO = new ApiDAO();
    private UserDAO userDAO = new UserDAO();
    private MessageDAO messageDAO = new MessageDAO();


    @Inject
    public MessageController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result getReceivedMessages(int userId) {
        User receiver = userDAO.getUserByUserId(userId);
        if (receiver == null)
            return notFound("User Not Found.");

        List<Message> messages = messageDAO.getReceivedMessages(receiver);
        List<JsonNode> messagesJson = new ArrayList<>();
        for (Message message: messages) {
            messagesJson.add(message.toJson());
        }

        return ok(Json.toJson(messagesJson));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result sendMessage() {
        JsonNode messageJson = request().body().asJson();
        int senderId = messageJson.findPath("sender_id").asInt();
        int receiverId = messageJson.findPath("receiver_id").asInt();
        String title = messageJson.findPath("title").textValue();
        String content = messageJson.findPath("content").textValue();

        User sender = userDAO.getUserByUserId(senderId);
        if (sender == null)
            return notFound("Sender Not Found");

        User receiver = userDAO.getUserByUserId(receiverId);
        if (receiver == null)
            return notFound("Receiver Not Found");

        Message message = sender.sendMessage(receiver, title, content);
        return ok(message.toJson());
    }
}
