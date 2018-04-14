package services.factories;

import models.*;

import java.util.List;

public class UserFactory extends AbstractFactory {

    @Override
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

    @Override
    public Api getApi(String apiType, String name, String homepage, String endpoint, String version, String scope, String description, String email, List<Integer> apiIds) {
        return null;
    }
}
