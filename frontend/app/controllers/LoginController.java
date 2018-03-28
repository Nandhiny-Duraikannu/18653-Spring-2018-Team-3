package controllers;

import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    public Result loginView () {
        return ok(views.html.login.render());
    }

    public Result signupView () {
        return ok(views.html.signup.render());
    }

}
