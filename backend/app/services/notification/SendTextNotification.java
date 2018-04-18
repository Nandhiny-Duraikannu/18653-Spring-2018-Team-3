package services.notification;

import models.User;
import services.message.ChatRoom;

public class SendTextNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(User sender, User receiver, String apiName, String destination, String activity) {
        ChatRoom chatRoom = new ChatRoom();
        TextNotification notification = new TextNotification();
        String notificationText = notification.send(apiName, destination, activity);
        chatRoom.sendMessage(sender, receiver, "Notification", notificationText);
    }
}
