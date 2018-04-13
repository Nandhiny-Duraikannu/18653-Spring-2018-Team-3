package controllers;

import UIForm.UserForm;
import com.fasterxml.jackson.databind.JsonNode;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import services.BackendURLService;
import views.html.userProfile;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class UserProfileController extends Controller {
    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public UserProfileController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    private static Result displayUserProfilePageWithContent(WSResponse r) {
        if (r.getStatus() == 200) {
            JsonNode body = Json.parse(r.getBody());
            UserForm userFormResult = Json.fromJson(body, UserForm.class);
            return ok(userProfile.render(userFormResult));
        } else {
            return ok(userProfile.render(new UserForm()));
        }
    }


    public CompletionStage<Result> getUserProfile () {
        int userId = Integer.valueOf(session().get("id"));
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.userProfileURL(userId));
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply(UserProfileController::displayUserProfilePageWithContent);
    }

    public CompletionStage<Result> updateUserProfile () {
        int userId = Integer.valueOf(session().get("id"));

        Form<UserForm> userForm = formFactory.form(UserForm.class).bindFromRequest();
        UserForm userData = userForm.get();
        userData.setId(userId);

        String userJson = Json.toJson(userData).toString();
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.userProfileURL(userData.getId()));
        return request
        .addHeader("Content-Type", "application/json")
        .post(userJson)
        .thenApply(UserProfileController::displayUserProfilePageWithContent);
    }

    public CompletionStage<Result> getAllUsers () {
        WSRequest request = ws.url(urlService.getAllUsersURL());
        return request
        .addHeader("Content-Type", "application/json")
        .get()
        .thenApply((WSResponse r) -> {
            return ok(r.getBody());
        });
    }
}
