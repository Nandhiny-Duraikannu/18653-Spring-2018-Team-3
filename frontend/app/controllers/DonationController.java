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

    public Result donationView(String showError, String payId) {
        String username = session().get("username");
        getAccessToken();
        return ok(views.html.makeDonation.render(username, showError,payId));
    }


    public String buildJSON(String cardnum, String name, String expireMonth, String expireYear, String cvv, String amount) {
        StringBuilder sb = new StringBuilder();

        sb.append("{\"intent\": \"sale\",\"payer\": {\"payment_method\": \"credit_card\",\"funding_instruments\": [ {");
        sb.append("\"credit_card\": {\"type\": \"visa\",\"number\": \"");
        sb.append(cardnum);
        sb.append("\",\"expire_month\": \"");
        sb.append(expireMonth);
        sb.append("\",\"expire_year\": \"");
        sb.append(expireYear);
        sb.append("\",\"cvv2\": \"");
        sb.append(cvv);
        sb.append("\",\"first_name\": \"");
        sb.append(name);
        sb.append("\",\"last_name\": \"shopper\" } }] },\"transactions\": [ {\"amount\": {");
        sb.append("\"currency\": \"USD\", \"total\": \"");
        sb.append(amount);
        sb.append("\" },\"description\": \"Donation\" }] }");

        return sb.toString();
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
                        System.out.println("success access token" + accessToken);
                        return ok("Access Token Success");

                    } else {
                        return badRequest("Failed access token");

                    }
                });
    }


    // Donate logic
    public CompletionStage<Result> donate()
    {
        Form<DonateForm> form = formFactory.form(DonateForm.class).bindFromRequest();
            DonateForm info = form.get();
            String cardnum = info.getCardNumber().replaceAll("\\s+", "");
            String expireMonth = info.getExpiryMonth();
            String expireYear = info.getExpiryYear();
            String cvv = info.getCvv();
            String amount = info.getAmount();
            String name = session().get("username");
            String requestBody = buildJSON(cardnum, name, expireMonth, expireYear, cvv, amount);
            String json = Json.toJson(requestBody).toString();
            accessToken = accessToken.replace("\"", "");
            String authorizationValue = "Bearer "+accessToken ;
            WSRequest request = ws.url(urlService.paypalPayment());
           return request
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization",authorizationValue )
                    .post(requestBody)
                    .thenApply((WSResponse r) -> {
                        if (r.getStatus() == 201) {
                             JsonNode jsonNode = Json.parse(r.getBody());
                            String paymentId = jsonNode.get("id").toString();
                            WSRequest backendRequest = ws.url(urlService.donateURL(paymentId));
                            System.out.println("paypal success");
                            return redirect(routes.DonationController.donationView("false",paymentId));
                        } else {
                            System.out.println("paypal payment failed"+r.getStatus());
                            return redirect(routes.DonationController.donationView("true"," "));
                        }
                    });


        }
}