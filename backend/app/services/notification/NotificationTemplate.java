package services.notification;

public abstract class NotificationTemplate {
    protected String subject;
    protected String title;
    protected String content;

    abstract void initialize();
    abstract void addSubject(String apiName);
    abstract void addTitle(String apiName);
    abstract void addContent();
    abstract void sendNotification(String destination);

    public final void send(String apiName, String destination) {
        initialize();
        addSubject(apiName);
        addTitle(apiName);
        addContent();
        sendNotification(destination);
    }
}
