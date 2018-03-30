package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.ws.*;
import play.mvc.*;
import services.BackendURLService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import com.fasterxml.jackson.databind.JsonNode;

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

    public Result loginView () {
        return ok(views.html.login.render());
    }

    public Result signupView () {
        return ok(views.html.signup.render());
    }

    // Signup logic
    public CompletionStage<Result> signup () {
        DynamicForm form = formFactory.form().bindFromRequest();

        StringBuilder userJSON = new StringBuilder();
        userJSON.append("{");
        userJSON.append("\"username\": \"").append(form.get("username")).append("\", ");
        userJSON.append("\"password\": \"").append(form.get("password")).append("\", ");
        userJSON.append("\"securityQuestion\": \"").append(form.get("securityQuestion")).append("\", ");
        userJSON.append("\"answer\": \"").append(form.get("answer")).append("\"} ");

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.signupURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(userJSON.toString())
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                int userId = r.asJson().get("id").asInt();
                String username = r.asJson().get("username").asText();
                return ok(views.html.homeUser.render(username, userId));
            } else {
                return badRequest("Error while trying to create user");
            }
        });
    }

    // Login logic
    public CompletionStage<Result> login () {

        DynamicForm form = formFactory.form().bindFromRequest();

        StringBuilder userJSON = new StringBuilder();
        userJSON.append("{");
        userJSON.append("\"username\": \"").append(form.get("username")).append("\", ");
        userJSON.append("\"password\": \"").append(form.get("password")).append("\"} ");
        //userJSON.append("\"password\": \"").append(form.get("password")).append("\", ");
        System.out.println(userJSON.toString());
       
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.loginURL());
        System.out.println(urlService.loginURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(userJSON.toString())
        .thenApply((WSResponse r) -> {
            System.out.println(r.getStatus());
            if (r.getStatus() == 200) {
                int userId = r.asJson().get("id").asInt();
                String username = r.asJson().get("username").asText();
                System.out.println("Login Sucess");
                return ok(views.html.homeUser.render(username, userId));
            } else {
                return badRequest("Error while trying to login user");
            }
        });
    }
}
