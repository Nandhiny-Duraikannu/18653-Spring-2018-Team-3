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
import com.fasterxml.jackson.databind.JsonNode;
import play.data.DynamicForm;





public class DonationController extends Controller implements WSBodyReadables, WSBodyWritables {

    private final FormFactory formFactory;
    private final WSClient ws;
    private final BackendURLService urlService;
    private String showError = "";
   public static String accessToken;

    @Inject
    public DonationController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result donationView(String showError) {
        String username = session().get("username");
        getAccessToken();
        return ok(views.html.makeDonation.render(username, showError));
    }

    public CompletionStage<Result> donate(){
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = session().get("username");
        String cardnum = form.get("cardnum");
        String month = form.get("month");
        String year = form.get("year");
        String cvv = form.get("cvv");
        String amount = form.get("amount");

        // Post the json to create payment in the backend
        String paymentJson = "{\"username\": \"" + username + "\",";
        paymentJson += "\"cardnum\": \"" + cardnum + "\",";
        paymentJson += "\"month\": \"" + month + "\",";
        paymentJson += "\"year\": \"" + year + "\",";
        paymentJson += "\"sec\": \"" + cvv + "\",";
        paymentJson += "\"amount\": \"" + amount + "\",";
        paymentJson += "\"accessToken\":" + accessToken + "}";
        // Post the json to create the user in the backend
        WSRequest request = ws.url(urlService.donateURL());
        return request
                .addHeader("Content-Type", "application/json")
                .post(paymentJson)
                .thenApply((WSResponse r) -> {
            if (r.getStatus() == 200) {
                        return redirect(routes.DonationController.donationView("false"));
                     } else {
                            return redirect(routes.DonationController.donationView("true"));
                    }
                });
    }


    public CompletionStage<Result> getAccessToken()
    {

        WSRequest request = ws.url(urlService.paypalAccessToken());
        return request
                .addHeader("Accept-Language", "en_US")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic QVFTZkdoYmFZYWVzVFhzWG85ODR0X1pwZmNPa093NVZ5VkxibG5NYm9HajVQR2FtZFI3NF9tOEQ4MjZLV3N2NDNCQjBUTTFzUDhiRFk3dWU6RUF3SWlPRGd1amcwM1ZLeVowdmZWZFo5a1lqSnJmQWtJeFhtaWEtQ0I4cFc1ZFRHWWJOQnNWSzFET1AzSU51OUZRX3NqU3BwWjVRS2dYYmw=")
                .post("grant_type=client_credentials")
                .thenApply((WSResponse x) -> {
                    if (x.getStatus() == 200) {
                        JsonNode jsonNode = Json.parse(x.getBody());
                        accessToken = jsonNode.get("access_token").toString();
                        return ok("Access Token Success");

                    } else {
                        return badRequest("Failed access token");

                    }
                });
    }

}