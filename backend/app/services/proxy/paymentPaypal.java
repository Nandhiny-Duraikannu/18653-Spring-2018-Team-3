package services.proxy;

import DAO.DonationDAO;
import models.Donation;
import play.libs.Json;
import play.libs.ws.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import java.util.*;
import play.mvc.Results;
import play.mvc.Result;

import play.data.FormFactory;

import javax.inject.Inject;

import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.data.Form;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import play.data.DynamicForm;


public class paymentPaypal implements paymentInterface, WSBodyReadables, WSBodyWritables {

    private final WSClient ws;
    public String paymentId;

    private DonationDAO donationDAO = new DonationDAO();
    public final String url_paypal = "https://api.sandbox.paypal.com/v1/payments/payment";

    @Inject
    public paymentPaypal(WSClient ws) {

        this.ws = ws;

    }

    public CompletionStage<Result> submitPayment(String username, String cardnum, String month, String year, String cvv,String amount, String accessToken)
    {

            String requestBody = buildJSON(username,cardnum,month,year,cvv,amount);
            String json = Json.toJson(requestBody).toString();
            WSRequest request = ws.url(url_paypal);
            accessToken = accessToken.replace("\"", "");
            String authorizationValue = "Bearer "+accessToken ;

        return request
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", authorizationValue)
                .post(requestBody)
                .thenApply((WSResponse r) -> {
                    if (r.getStatus() == 201) {
                        JsonNode jsonNode = Json.parse(r.getBody());
                        paymentId = jsonNode.get("id").toString();
                        paymentId = paymentId.replace("\"", "");
                        Donation donate = donationDAO.createInvoice(username, cardnum, month, year, cvv, amount, paymentId);
                       // return CompletableFuture.completedFuture(paymentId);
                        return Results.ok(paymentId);
                    } else {
                        return Results.badRequest("Error in processing transaction");
                    }
                });

    }





    public String buildJSON(String username, String cardnum, String month, String year, String cvv, String amount) {
        StringBuilder sb = new StringBuilder();

        sb.append("{\"intent\": \"sale\",\"payer\": {\"payment_method\": \"credit_card\",\"funding_instruments\": [ {");
        sb.append("\"credit_card\": {\"type\": \"visa\",\"number\": \"");
        sb.append(cardnum);
        sb.append("\",\"expire_month\": \"");
        sb.append(month);
        sb.append("\",\"expire_year\": \"");
        sb.append(year);
        sb.append("\",\"cvv2\": \"");
        sb.append(cvv);
        sb.append("\",\"first_name\": \"");
        sb.append(username);
        sb.append("\",\"last_name\": \"shopper\" } }] },\"transactions\": [ {\"amount\": {");
        sb.append("\"currency\": \"USD\", \"total\": \"");
        sb.append(amount);
        sb.append("\" },\"description\": \"Donation\" }] }");

        return sb.toString();
    }


}

