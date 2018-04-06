package services.notification;

public class TextNotification extends NotificationTemplate {
    @Override
    void initialize() {

    }

    @Override
    void addSubject() {

    }

    @Override
    void addTitle() {

    }

    @Override
    void addContent() {

    }

    @Override
    void sendNotification(String destination) {
        System.out.println("Notification Text Message has been sent to: "+destination);
    }
}
