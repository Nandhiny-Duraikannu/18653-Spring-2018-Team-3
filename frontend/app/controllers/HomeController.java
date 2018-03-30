package controllers;

import play.mvc.*;

public class HomeController extends Controller {

    public Result homeView (int userId) {
        String username = "test";
        return ok(views.html.homeUser.render(userId, username));
    }

}
