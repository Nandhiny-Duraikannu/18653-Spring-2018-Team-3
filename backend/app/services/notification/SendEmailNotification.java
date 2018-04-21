package services.notification;

import enums.NotificationType;
import models.Message;
import models.User;
import services.message.ChatRoom;

public class SendEmailNotification extends SendNotificationAPI {

    public SendEmailNotification(String apiName, String destination, NotificationType notificationType) {
        super(apiName, destination, notificationType);
    }

    @Override
    public Message send(User sender, User receiver, String title, String message) {
        EmailNotification notification = new EmailNotification();
        String notificationText = notification.send(apiName, destination, notificationType);
        return chatRoom.send(sender, receiver, "Notification", notificationText);
    }
}
