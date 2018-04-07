package controllers;

import play.mvc.*;
import java.util.*;
import UIForm.*;
import play.libs.ws.*;
import play.data.FormFactory;
import services.*;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;
import UIForm.LoginForm;
import UIForm.ResetPasswordForm;
import UIForm.SignupForm;
import UIForm.NewPasswordForm;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;
import play.mvc.Http.*;
import services.BackendURLService;
import play.data.Form;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;


public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public HomeController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result homeView () {
        String username = session().get("username");
        // int userId = Integer.valueOf(session().get("id"));
        // List<ApiForm> followers = new ArrayList<>();
        // followers.add (new ApiForm());

        // String url = urlService.getFollowers(userId);
        // System.out.println(url);
        // WSRequest request = ws.url(url);
        // return request
        // .addHeader("Content-Type", "application/json")
        // .get()
        // .thenApply((WSResponse r) -> {
        //     if (r.getStatus() == 200) {

        //         return redirect(routes.HomeController.homeView());
        //     } else {
        //         return badRequest("no");
        //     }
        // });


        return ok(views.html.homeUser.render(username));
    }

}
