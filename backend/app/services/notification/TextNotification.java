package services.notification;

public class TextNotification extends NotificationTemplate {

    @Override
    void initialize() {

    }

    @Override
    void addSubject(String apiName) {
        subject = "Text Notification for Api: " + apiName;
    }

    @Override
    void addTitle(String apiName) {
        title = "Acivity on API: " + apiName;
    }

    @Override
    void addContent() {
        content = "You received this text message because someone followed this API.";
    }

    @Override
    void sendNotification(String destination) {
        System.out.println("Notification Text Message has been sent to: "+destination);
        System.out.println("+-------------------- Text Message ---------------------+");
        System.out.println("+ Subject: " + subject);
        System.out.println("+ Title: " + title);
        System.out.println("+ Content: " + content);
        System.out.println("+-------------------------------------------------------+");
    }
}
