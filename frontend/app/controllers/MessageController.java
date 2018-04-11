package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class MessageController extends Controller {

    public Result showMessageView () { return ok(views.html.messages.render()); }

}
