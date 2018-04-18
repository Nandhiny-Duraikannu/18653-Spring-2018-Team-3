package services.notification;

import enums.NotificationType;
import models.User;
import services.message.ChatRoom;

public class SendTextNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(User sender, User receiver, String apiName, String destination, NotificationType notificationType) {
        ChatRoom chatRoom = new ChatRoom();
        TextNotification notification = new TextNotification();
        String notificationText = notification.send(apiName, destination, notificationType);
        chatRoom.sendMessage(sender, receiver, "Notification", notificationText);
    }
}
