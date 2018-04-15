package DAO;

import models.User;
import services.factories.*;

import java.util.Iterator;
import java.util.List;

public class UserDAO {
    private AbstractFactory userFactory = FactoryProducer.getFactory("user");

    public User createNewUser(String username, String password, String securityQuestion, String answer) {
        User user = userFactory.getUser("normal_user");
        user.setParameters(username, password, securityQuestion, answer);
        user.save();
        return user;
    }

    public User getUserByUsername(String username) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("username", username).findUnique();
            if (user == null) {
                return null;
            } else {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByUserId (int id) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("id", id).findUnique();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAllUsers () {
        User userDB = new User();
        List<User> users = userDB.find.all();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        String comma = "";

        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User currentUser = userIterator.next();
            stringBuffer.append(comma);
            comma = ", ";
            stringBuffer.append(currentUser.toJSON());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public User updateUserProfile (int userId, String name, String email, String phoneNumber, String
            notificationMethod) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("id", userId).findUnique();
            if (user == null) {
                return null;
            } else {
                user.setName(name);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setNotificationMethod(notificationMethod);
                user.save();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
