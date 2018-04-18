package services.notification;

import enums.NotificationType;
import models.User;
import services.message.ChatRoom;

public class SendPhoneNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(User sender, User receiver, String apiTitle, String destination, NotificationType notificationType) {
        ChatRoom chatRoom = new ChatRoom();
        PhoneNotification notification = new PhoneNotification();
        String notificationText = notification.send(apiTitle, destination, notificationType);
        chatRoom.sendMessage(sender, receiver, "Notification", notificationText);
    }
}
