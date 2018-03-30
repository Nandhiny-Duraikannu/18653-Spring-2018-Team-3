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
        String username = form.get("username");
        String password = form.get("password");
        String securityQuestion = form.get("securityQuestion");
        String answer = form.get("answer");
        User user = userDAO.createNewUser(username, password, securityQuestion, answer);
        return ok(user.toJSON());
    }

    public Result login() {
        DynamicForm form = formFactory.form().bindFromRequest();

            if (form.data().size() != 2) {
                System.out.println("Why I am here??");
                return badRequest("Bad Login Request");
            } else {
            String username = form.get("username");
            String password = form.get("password");
            //System.out.println("User name is : ", username);
            User user = userDAO.getPassword(username);
            String dbPassword = user.passwordHash;
            if (password.equals(dbPassword)) {
                return ok(user.toJSON());
            } else {
                return notFound("Invalid Login");
            }
        }
    }
}

