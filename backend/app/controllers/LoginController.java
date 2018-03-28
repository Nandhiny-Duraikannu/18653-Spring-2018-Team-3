package controllers;

import DAO.UserDAO;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {
    private final FormFactory formFactory;

    private UserDAO userDAO = new UserDAO();

    @Inject
    public LoginController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result signup() {
        DynamicForm form = formFactory.form().bindFromRequest();
        System.out.println(form);
        String username = form.get("username");
        System.out.println(username);
        String password = form.get("password");
        System.out.println(password);
        String securityQuestion = form.get("securityQuestion");
        System.out.println(securityQuestion);
        String answer = form.get("answer");
        System.out.println(answer);
        User user = userDAO.createNewUser(username, password, securityQuestion, answer);
        return ok(user.toJSON());
    }

}
