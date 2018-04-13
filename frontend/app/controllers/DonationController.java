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
    private String showError = "";

    @Inject
    public DonationController(WSClient ws, FormFactory formFactory) {
        this.ws = ws;
        this.formFactory = formFactory;
        this.urlService = new BackendURLService();
    }

    public Result donationView (String showError) {
        return ok(views.html.makeDonation.render(showError));
    }


    public String buildJSON (String cardnum,String name,String expireMonth,String expireYear,String cvv,String amount)
    {
       StringBuilder sb = new StringBuilder();

        sb.append("{\"intent\": \"sale\",\"payer\": {\"payment_method\": \"credit_card\",\"funding_instruments\": [ {" );
        sb.append("\"credit_card\": {\"type\": \"visa\",\"number\": \"");
        sb.append(cardnum);
                sb.append("\",\"expire_month\": \"");
                sb.append(expireMonth);
                        sb.append("\",\"expire_year\": \"");
                                sb.append(expireYear);
                                        sb.append("\",\"cvv2\": \"") ;
                                                sb.append(cvv);
                                        sb.append("\",\"first_name\": \"") ;
                                          sb.append(name);
                                          sb.append("\",\"last_name\": \"shopper\" } }] },\"transactions\": [ {\"amount\": {");
        sb.append("\"currency\": \"USD\", \"total\": \"");
                sb.append(amount);
        sb.append("\" },\"description\": \"Donation\" }] }");

        System.out.println("sb:"+sb);
        return sb.toString();
    }


       // Donate logic
    public CompletionStage<Result> donate () {
        Form<DonateForm> form = formFactory.form(DonateForm.class).bindFromRequest();
        DonateForm info = form.get();
        String cardnum = info.getCardNumber().replaceAll("\\s+","");
        System.out.println("cardnum:"+cardnum);
        String expireMonth=info.getExpiryMonth();
        String expireYear=info.getExpiryYear();
        String cvv = info.getCvv();
        String amount =info.getAmount();
        String name = session().get("username");
        String requestBody = buildJSON(cardnum,name,expireMonth,expireYear,cvv,amount);
        String json = Json.toJson(requestBody).toString();
        WSRequest request = ws.url(urlService.paypalPayment());
        return request
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer A21AAGBUSVjupUjKiPBSH-qTykZdYAuZugExcCbDr5arxqvchDJ8XXz7eQgLsQHoRo3BaIxIvzgO4gVrGjXqZLRC3YevmkBGw")
                .post(requestBody)
                .thenApply((WSResponse r) -> {
            if (r.getStatus() == 201) {
                // String donate = "{\"username\": \"" + session().get("username") + "\",";
                // donate += "\"invoiceid\": \"" + formData.getPassword() + "\"}";
                
                // //Post the json to create the user in the backend
                // WSRequest request = ws.url(urlService.donateURL());

                // return request
                // .addHeader("Content-Type", "application/json")
                // .post(donate)
                // .thenApply((WSResponse r) -> {
                //     if (r.getStatus() == 200) {
                //         return redirect(routes.LoginController.loginView(false));
                //     } else {
                //         return redirect(routes.LoginController.resetPasswordView());
                //     }
                // });
                return redirect(routes.DonationController.donationView("false"));
            } else {
                System.out.println("failed");
                return redirect(routes.DonationController.donationView("true"));
            }
        }

        );
    }

}