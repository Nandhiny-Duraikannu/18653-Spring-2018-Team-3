package services.notification;

import models.*;

public interface SendNotificationAPI {
    void sendNotification(User sender, User receiver, String apiName, String destination, String activity);
}
