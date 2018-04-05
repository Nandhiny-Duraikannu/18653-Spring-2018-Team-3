package controllers;

import DAO.UserDAO;
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

}
