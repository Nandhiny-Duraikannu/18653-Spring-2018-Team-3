package services.notification;

import enums.NotificationType;

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
    void addContent(NotificationType notificationType) {
        content = "You received this text message because ";
        if (notificationType == NotificationType.FOLLOW_NOTIFICATION)
            content += "someone followed this API. ";
        else if (notificationType == NotificationType.APPROVE_NOTIFICATION)
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
