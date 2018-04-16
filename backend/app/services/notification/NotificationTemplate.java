package services.notification;

public abstract class NotificationTemplate {
    protected String subject;
    protected String title;
    protected String content;

    abstract void initialize();
    abstract void addSubject(String apiName);
    abstract void addTitle(String apiName);
    abstract void addContent(String activity);
    abstract String sendNotification(String destination);

    public final String send(String apiName, String destination, String activity) {
        initialize();
        addSubject(apiName);
        addTitle(apiName);
        addContent(activity);
        return sendNotification(destination);
    }
}
