package services.message;

import DAO.MessageDAO;
import com.fasterxml.jackson.databind.JsonNode;
import models.Api;
import models.Message;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class MessageChatRoom implements ChatRoom {

    @Override
    public Message send(User sender, User receiver, String title, String message) {
        return messageDAO.create(sender, receiver, title, message);
    }

    public List<JsonNode> getReceivedMessagesForUser (User user) {
        List<Message> messages = messageDAO.getReceivedMessages(user);
        List<JsonNode> messagesJson = new ArrayList<>();
        for (Message message: messages) {
            messagesJson.add(message.toJson());
        }
        return messagesJson;
    }

    public void sendMessageToFollowers (User sender, String title, String content) {
        List<Api> apis = sender.getApis();
        for (Api api: apis) {
            for (User follower: api.getFollowers())
                this.send(sender, follower, title, content);
        }
    }
}
