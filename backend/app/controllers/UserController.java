package controllers;

import DAO.UserDAO;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

public class UserController extends Controller {

    private final FormFactory formFactory;

    private UserDAO userDAO = new UserDAO();

    @Inject
    public UserController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result getAllUsers () {
        String allUsers = userDAO.getAllUsers();
        return ok(allUsers);
    }

    public Result getUserProfile (int userId) {
        User userProfile = userDAO.getUserByUserId(userId);
        return ok(userProfile.profileToJson());
    }

    public Result updateUserProfile (int userId) {
        DynamicForm form = formFactory.form().bindFromRequest();
        String name = form.get("name");
        String email = form.get("email");
        String phoneNumber = form.get("phoneNumber");
        String notificationMethod = form.get("notificationMethod");

        User user = userDAO.updateUserProfile(userId, name, email, phoneNumber, notificationMethod);

        if (user == null) {
            return badRequest("Error while updating user profile");
        } else {
            return ok(user.profileToJson());
        }
    }

}