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
        title = "Acivity on API: " + apiName + ". ";
    }

    @Override
    void addContent() {
        content = "You received this phone call because someone followed this API.";
    }

    @Override
    String sendNotification(String destination) {
        StringBuilder sb = new StringBuilder();
        sb.append("Phone Call Notification has been made to: "+destination+". ");
        sb.append(title);
        sb.append(content);

        return sb.toString();
    }
}
