package services.notification;

import enums.*;

public abstract class NotificationTemplate {
    protected String subject;
    protected String title;
    protected String content;

    abstract void initialize();
    abstract void addSubject(String apiName);
    abstract void addTitle(String apiName);
    abstract void addContent(NotificationType notificationType);
    abstract String sendNotification(String destination);

    public final String send(String apiName, String destination, NotificationType notificationType) {
        initialize();
        addSubject(apiName);
        addTitle(apiName);
        addContent(notificationType);
        return sendNotification(destination);
    }
}
