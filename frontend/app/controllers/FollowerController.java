package controllers;

import play.mvc.*;

public class FollowerController extends Controller {

    public Result myFollowersView () {
        String username = session().get("username");
        return ok(views.html.myFollowers.render(username));
    }

}
