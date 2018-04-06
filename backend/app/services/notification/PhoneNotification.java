package services.notification;

public class PhoneNotification extends NotificationTemplate {

    @Override
    void initialize() {

    }

    @Override
    void addSubject(String apiName) {
        subject = "Phone Notification for Api: " + apiName;
    }

    @Override
    void addTitle(String apiName) {
        title = "Acivity on API: " + apiName;
    }

    @Override
    void addContent() {
        content = "You received this phone call because someone posted a comment under this API.";
    }

    @Override
    void sendNotification(String destination) {
        System.out.println("Phone Call Notification has been made to: "+destination);
        System.out.println("+----------------------- Phone -------------------------+");
        System.out.println("+ Subject: " + subject);
        System.out.println("+ Title: " + title);
        System.out.println("+ Content: " + content);
        System.out.println("+-------------------------------------------------------+");
    }
}
