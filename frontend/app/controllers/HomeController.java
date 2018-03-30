package controllers;

import play.mvc.*;

public class HomeController extends Controller {

    public Result homeView () {
        return ok(views.html.homeUser.render(Integer.valueOf(session().get("id")), session().get("username")));
    }

}
