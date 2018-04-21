package services.notification;

import enums.NotificationType;
import models.Message;
import models.User;
import services.message.ChatRoom;

public class SendTextNotification extends SendNotificationAPI {

    public SendTextNotification(String apiName, String destination, NotificationType notificationType) {
        super(apiName, destination, notificationType);
    }

    @Override
    public Message send(User sender, User receiver, String title, String message) {
        TextNotification notification = new TextNotification();
        String notificationText = notification.send(apiName, destination, notificationType);
        return chatRoom.send(sender, receiver, "Notification", notificationText);
    }
}
