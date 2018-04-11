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


public class DonationController extends Controller implements WSBodyReadables, WSBodyWritables {

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;

    @Inject
    public DonationController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result donationView (boolean showError) {
        return ok(views.html.makeDonation.render(showError));
    }


       // Donate logic
    public CompletionStage<Result> donate () {
        Form<DonateForm> form = formFactory.form(DonateForm.class).bindFromRequest();
        DonateForm info = form.get();
        String json = Json.toJson(info).toString();

        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.donateURL());
        return request
        .addHeader("Content-Type", "application/json")
        .post(json)
        .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                String invoiceID = r.asJson().get("invoiceID").asText();
                return redirect(routes.DonationController.donationView(false));
            } else {
                return redirect(routes.DonationController.donationView(true));
            }
        });
    }

}