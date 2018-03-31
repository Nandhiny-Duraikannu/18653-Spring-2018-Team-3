package controllers;

import play.mvc.*;

public class HomeController extends Controller {

    public Result homeView () {
        return ok(views.html.homeUser.render(session().get("username")));
    }

}
