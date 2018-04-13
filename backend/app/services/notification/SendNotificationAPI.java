package services.notification;

import models.*;

public interface SendNotificationAPI {
    public void sendNotification(User sender, User receiver, String apiName, String destination);
}
