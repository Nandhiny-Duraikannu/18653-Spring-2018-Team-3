package services.factories;

import models.Api;
import models.User;
import enums.UserType;

import java.util.List;

public class UserFactory extends AbstractFactory {

    @Override
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

    @Override
    public Api getApi(String apiType, String name, String homepage, String endpoint, String version, String scope, String description, String email, List<Integer> apiIds) {
        return null;
    }
}
