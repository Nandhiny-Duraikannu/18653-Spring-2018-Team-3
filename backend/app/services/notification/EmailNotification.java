package services.notification;

public class EmailNotification extends NotificationTemplate {
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
        System.out.println("Notification Email has been sent to: "+destination);
    }
}
