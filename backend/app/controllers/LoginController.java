package controllers;

import DAO.UserDAO;
import forms.LoginForm;
import forms.ResetPasswordForm;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

public class LoginController extends Controller {
    private final FormFactory formFactory;

    private UserDAO userDAO;

    @Inject
    public LoginController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.userDAO = new UserDAO();
        this.userDAO.ensureOneAdmin();
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
        Form<LoginForm> form = formFactory.form(LoginForm.class).bindFromRequest();
        LoginForm loginData = form.get();
        String username = loginData.getUsername();
        String password = loginData.getPassword();
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.authenticate(password)) {
            return ok(user.toJSON());
        } else {
            return notFound("Invalid Login");
        }
    }

    public Result forgotPwd() {
        Form<ResetPasswordForm> form = formFactory.form(ResetPasswordForm.class).bindFromRequest();
        ResetPasswordForm passwordForm = form.get();

        String username = passwordForm.getUsername();
        String securityQuestion = passwordForm.getSecurityQuestion();
        String answer = passwordForm.getAnswer();
        User user = userDAO.getUserByUsername(username);
        if (
            username.equals(user.getUsername()) &&
            securityQuestion.equals(user.getSecurityQuestion()) &&
            answer.equals(user.getAnswer())) {
            user.updatePassword("temp");
            return ok("{\"reset\": true}");
        } else {
            return ok("{\"reset\": false}");
        }
    }
}

