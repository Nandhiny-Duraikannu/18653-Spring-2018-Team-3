package controllers;

import DAO.*;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;
import services.command.*;

import javax.inject.Inject;

public class UserController extends Controller {

    private final FormFactory formFactory;

    GetUserByUserId getUserByUserIdCommand = new GetUserByUserId();
    GetAllUsers getAllUsersCommand = new GetAllUsers();
    UpdateUserProfile updateUserProfileCommand = new UpdateUserProfile(); 
    RequestBroker rb = new RequestBroker();

    @Inject
    public UserController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result getAllUsers () {
        rb.setCommand(getAllUsersCommand);
        rb.executeCommand();
        String allUsers = getAllUsersCommand.getAllUsers();
        return ok(allUsers);
    }

    public Result getUserProfile (int userId) {
        rb.setCommand(getUserByUserIdCommand);
        getUserByUserIdCommand.setUserByUserIdParams(userId);
        rb.executeCommand();

        User userProfile = getUserByUserIdCommand.getUserByUserId();
        return ok(userProfile.profileToJson());
    }

    public Result updateUserProfile (int userId) {
        DynamicForm form = formFactory.form().bindFromRequest();
        String name = form.get("name");
        String email = form.get("email");
        String phoneNumber = form.get("phoneNumber");
        String notificationMethod = form.get("notificationMethod");
        rb.setCommand(updateUserProfileCommand);
        updateUserProfileCommand.setUpdateUserProfileParams(userId, name, email, phoneNumber, notificationMethod);
        rb.executeCommand();

        User user = updateUserProfileCommand.getUpdateUser();

        if (user == null) {
            return badRequest("Error while updating user profile");
        } else {
            return ok(user.profileToJson());
        }
    }

}