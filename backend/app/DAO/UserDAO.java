package DAO;

import com.avaje.ebean.Ebean;
import io.ebean.*;
import com.avaje.ebean.*;
import com.avaje.ebean.Transaction;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.format.*;

import models.User;
import services.UserFactory;

import java.util.List;

public class UserDAO {
    private UserFactory userFactory = new UserFactory();

    public User createNewUser(String username, String password, String securityQuestion, String answer) {
        User user = userFactory.getUser("normal_user");
        user.setParameters(username, password, securityQuestion, answer);
        user.save();
        return user;
    }

    public User getPassword(String username) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("username", username).findUnique();
            if (user == null) return null;
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
