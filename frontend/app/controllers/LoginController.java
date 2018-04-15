package controllers;

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

    public Result loginView (boolean showWrongPassword) { return ok(views.html.login.render(showWrongPassword)); }

    public Result signupView (boolean showError) {
        return ok(views.html.signup.render(showError));
    }

    public Result forgotPwdView () {
        return ok(views.html.forgotPwd.render());
    }

    public Result resetPasswordView () { return ok(views.html.resetPassword.render()); }

    public Result logout () {
        session().clear();
        return redirect(routes.LoginController.loginView(false));
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
                return redirect(routes.LoginController.loginView(false));
            } else {
                return redirect(routes.LoginController.signupView(true));
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
                String userType = r.asJson().get("type").asText();
                ctx.session().clear();
                ctx.session().put("id", String.valueOf(userId));
                ctx.session().put("username", username);
                ctx.session().put("type", userType);
                return redirect(routes.HomeController.homeView());
            } else {
                return redirect(routes.LoginController.loginView(true));
            }
        });
    }

     // Login logic
    public CompletionStage<Result> forgotPwd () {
        Form<ResetPasswordForm> resetPasswordForm = formFactory.form(ResetPasswordForm.class).bindFromRequest();
        ResetPasswordForm formData = resetPasswordForm.get();
        String formJson = Json.toJson(formData).toString();
        Context ctx = Http.Context.current();
        // Post the json to create the user in the backend
        System.out.println(formJson);
        WSRequest request = ws.url(urlService.resetPasswordURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(formJson)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                String username = r.asJson().get("username").asText();
                boolean reset = r.asJson().get("reset").asBoolean();
                ctx.session().clear();
                ctx.session().put("username", username);
                if (reset) {
                    return redirect(routes.LoginController.resetPasswordView());
                } else {
                    return redirect(routes.LoginController.forgotPwdView());
                }

            } else {
                return badRequest("Error while trying to reset password");
            }
        });
    }

    public CompletionStage<Result> resetPassword () {
        Form<NewPasswordForm> newPasswordForm = formFactory.form(NewPasswordForm.class).bindFromRequest();
        NewPasswordForm formData = newPasswordForm.get();
        String reset = "{\"username\": \"" + session().get("username") + "\",";
        reset += "\"newPassword\": \"" + formData.getPassword() + "\"}";
        
        //Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.newPasswordURL());

        return request
        .addHeader("Content-Type", "application/json")
        .post(reset)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                return redirect(routes.LoginController.loginView(false));
            } else {
                return redirect(routes.LoginController.resetPasswordView());
            }
        });
    }
}
