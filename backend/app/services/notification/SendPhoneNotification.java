package services.notification;

public class SendPhoneNotification implements SendNotificationAPI {
    @Override
    public void sendNotification(String apiTitle, String destination) {
        PhoneNotification notification = new PhoneNotification();
        notification.send(apiTitle, destination);
    }
}
