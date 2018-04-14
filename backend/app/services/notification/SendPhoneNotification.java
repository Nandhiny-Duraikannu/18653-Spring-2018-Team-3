package services.notification;

import models.User;
import services.message.ChatRoom;

public class SendPhoneNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(User sender, User receiver, String apiTitle, String destination) {
        ChatRoom chatRoom = new ChatRoom();
        PhoneNotification notification = new PhoneNotification();
        String notificationText = notification.send(apiTitle, destination);
        chatRoom.sendMessage(sender, receiver, "Notification", notificationText);
    }
}
