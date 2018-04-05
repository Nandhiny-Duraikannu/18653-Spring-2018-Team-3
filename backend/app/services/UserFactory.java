package services;

import models.User;

public class UserFactory {

    public User getUser(String type) {
        if (type.equalsIgnoreCase("NORMAL_USER")) {
            User user = new User();
            user.setUserType("user");
            return user;
        } else if (type.equalsIgnoreCase("ADMIN_USER")) {
            User admin = new User();
            admin.setUserType("admin");
            return admin;
        } else {
            return null;
        }
    }

}
