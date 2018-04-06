package services.notification;

public class SendEmailNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(String apiName, String destination) {
        EmailNotification notification = new EmailNotification();
        notification.send(apiName, destination);
    }
}
