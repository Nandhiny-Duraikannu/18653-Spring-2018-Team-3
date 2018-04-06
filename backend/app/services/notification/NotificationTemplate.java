package services.notification;

public abstract class NotificationTemplate {
    abstract void initialize();
    abstract void addSubject();
    abstract void addTitle();
    abstract void addContent();
    abstract void sendNotification(String destination);

    public final void send(String destination) {
        initialize();
        addSubject();
        addTitle();
        addContent();
        sendNotification(destination);
    }
}
