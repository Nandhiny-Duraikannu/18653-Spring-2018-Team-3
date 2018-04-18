package services.notification;

import models.*;
import enums.*;

public interface SendNotificationAPI {
    void sendNotification(User sender, User receiver, String apiName, String destination, NotificationType notificationType);
}
