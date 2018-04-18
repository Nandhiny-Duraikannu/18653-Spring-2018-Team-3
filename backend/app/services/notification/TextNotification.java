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
        title = "Acivity on API: " + apiName + ". ";
    }

    @Override
    void addContent(String activity) {
        content = "You received this text message because ";
        if (activity.equalsIgnoreCase("follow"))
            content += "someone followed this API. ";
        else if (activity.equalsIgnoreCase("approve"))
            content += "an admin approved this API. ";
        else
            content += "an activity happened to this API. ";
    }

    @Override
    String sendNotification(String destination) {
        StringBuilder sb = new StringBuilder();
        sb.append("Text Notification has been sent to: "+destination+". ");
        sb.append(title);
        sb.append(content);

        return sb.toString();
    }
}
