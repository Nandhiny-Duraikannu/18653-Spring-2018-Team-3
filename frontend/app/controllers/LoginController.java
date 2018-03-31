package controllers;

import UIForm.LoginForm;
import UIForm.ResetPasswordForm;
import UIForm.SignupForm;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;
import play.mvc.Http.*;
import services.BackendURLService;
import play.data.Form;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller implements WSBodyReadables, WSBodyWritables {

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public LoginController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result loginView () { return ok(views.html.login.render()); }

    public Result signupView () {
        return ok(views.html.signup.render());
    }

    public Result forgotPwdView () {
        return ok(views.html.forgotPwd.render());
    }

    public Result resetPasswordView () { return ok(views.html.resetPassword.render()); }

    public Result logout () {
        session().clear();
        return redirect(routes.LoginController.loginView());
    }

    // Signup logic
    public CompletionStage<Result> signup () {
        Form<SignupForm> form = formFactory.form(SignupForm.class).bindFromRequest();
        SignupForm info = form.get();
        String json = Json.toJson(info).toString();

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.signupURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(json)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                int userId = r.asJson().get("id").asInt();
                String username = r.asJson().get("username").asText();
                return redirect(routes.LoginController.loginView());
            } else {
                return badRequest("Error while trying to create user");
            }
        });
    }

    // Login logic
    public CompletionStage<Result> login () {
        Form<LoginForm> loginForm = formFactory.form(LoginForm.class).bindFromRequest();
        LoginForm incomingForm = loginForm.get();
        String userJSON = Json.toJson(incomingForm).toString();
        Context ctx = Http.Context.current();
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.loginURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(userJSON)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                int userId = r.asJson().get("id").asInt();
                String username = r.asJson().get("username").asText();
                ctx.session().clear();
                ctx.session().put("id", String.valueOf(userId));
                ctx.session().put("username", username);
                return redirect(routes.HomeController.homeView());
            } else {
                return badRequest("Error while trying to login user");
            }
        });
    }

     // Login logic
    public CompletionStage<Result> forgotPwd () {
        Form<ResetPasswordForm> resetPasswordForm = formFactory.form(ResetPasswordForm.class).bindFromRequest();
        ResetPasswordForm formData = resetPasswordForm.get();
        String formJson = Json.toJson(formData).toString();

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.resetPasswordURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(formJson)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                boolean reset = r.asJson().get("reset").asBoolean();
                if (reset) {
                    return redirect(routes.LoginController.loginView());
                } else {
                    return redirect(routes.LoginController.forgotPwdView());
                }

            } else {
                return badRequest("Error while trying to reset password");
            }
        });
    }

    public CompletionStage<Result> resetPassword () {
        Form<SignupForm> resetPasswordForm = formFactory.form(SignupForm.class).bindFromRequest();
        SignupForm formData = resetPasswordForm.get();
        String newPassword = "{\"newPassword\": \"" + formData.getPassword() + "\"}";
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.newPasswordURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(newPassword)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return redirect(routes.LoginController.loginView());
            } else {
                return badRequest("Error while trying to reset password");
            }
        });
    }
}
