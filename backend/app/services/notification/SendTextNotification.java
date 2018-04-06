package services.notification;

public class SendTextNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(String apiName, String destination) {
        TextNotification notification = new TextNotification();
        notification.send(apiName, destination);
    }
}
