package controllers;

import play.mvc.*;

public class FollowerController extends Controller {

    public Result myFollowersView () {
        String username = session().get("username");
        String userType = session().get("type");
        return ok(views.html.myFollowers.render(username, userType));
    }

}
