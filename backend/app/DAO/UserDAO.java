package DAO;

import models.User;
import services.UserFactory;

import java.util.List;

public class UserDAO {
    private UserFactory userFactory = new UserFactory();

    public User createNewUser(String username, String password, String securityQuestion, String answer) {
        User user = userFactory.getUser("normal_user");
        System.out.println(user);
        user.setParameters(username, password, securityQuestion, answer);
        user.save();
        return user;
    }

    public String getAllUsers () {
        User userDB = new User();
        List<User> users = userDB.find.all();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        String comma = "";
        for (User user : users) {
            stringBuffer.append(comma);
            comma = ", ";
            stringBuffer.append(user.toJSON());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
