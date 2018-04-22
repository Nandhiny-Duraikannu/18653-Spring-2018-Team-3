package services.notification;

import models.*;
import enums.*;
import services.message.ChatRoom;
import services.message.MessageChatRoom;

public abstract class SendNotificationAPI implements ChatRoom {
    protected ChatRoom chatRoom;
    protected String apiName;
    protected String destination;
    protected NotificationType notificationType;

    public SendNotificationAPI(String apiName, String destination, NotificationType notificationType) {
        this.chatRoom = new MessageChatRoom();
        this.apiName = apiName;
        this.destination = destination;
        this.notificationType = notificationType;
    }

    abstract public Message send(User sender, User receiver, String title, String message);
}
