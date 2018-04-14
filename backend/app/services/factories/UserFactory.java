package services.factories;

import models.User;
import models.UserType;

public class UserFactory {

    public User getUser(UserType type) {
        if (type.equals(UserType.STANDARD_USER)) {
            User user = new User();
            user.setUserType(UserType.STANDARD_USER);
            return user;
        } else if (type.equals(UserType.ADMIN_USER)) {
            User admin = new User();
            admin.setUserType(UserType.ADMIN_USER);
            return admin;
        } else {
            return null;
        }
    }

}
