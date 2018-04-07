package controllers;

import play.mvc.*;

public class FollowerController extends Controller {

    public Result myFollowersView () {
        return ok(views.html.myFollowers.render());
    }

}
