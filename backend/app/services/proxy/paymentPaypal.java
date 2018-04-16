package services.proxy;

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
import play.libs.WS.WSRequest;
import play.data.Form;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import play.data.DynamicForm;


public class paymentPaypal implements paymentInterface, WSBodyReadables, WSBodyWritables {

    private final WSClient ws;
    public String accessToken;
    public String paymentId;

    public final String url_paypal = "https://api.sandbox.paypal.com/v1/payments/payment";
    public final String url_accessToken = "https://api.sandbox.paypal.com/v1/oauth2/token";

    @Inject
    public paymentPaypal() {
        System.out.println("insisde constructor");

      // this.ws = ws;
    }

    @Override
    public String payment(String username, String cardnum, String month, String year, String cvv,String amount){

        System.out.println("test in class");
       getAccessToken(url_accessToken);
        System.out.println("accessToken"+accessToken);
        submitPayment(username,cardnum,month,year,cvv,amount,accessToken);
        System.out.println("paymentId:"+paymentId);
      //  String payId = "payidtest";
        return paymentId;


    }

    public CompletionStage<Result> submitPayment(String username, String cardnum, String month, String year, String cvv,String amount, String accessToken) {

            String requestBody = buildJSON(username,cardnum,month,year,cvv,amount);
            String json = Json.toJson(requestBody).toString();
            accessToken = accessToken.replace("\"", "");
            String authorizationValue = "Bearer "+accessToken ;

            WSRequest request = ws.url(url_paypal);
           return request
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization",authorizationValue )
                    .post(requestBody)
                    .thenApply((WSResponse r) -> {
                        if (r.getStatus() == 201) {
                             JsonNode jsonNode = Json.parse(r.getBody());
                            paymentId = jsonNode.get("id").toString();
                            return Results.ok("Payment Successful"+paymentId);
                        } else {
                            return Results.badRequest("Failed Transaction");
                        }
                    });

    }

    public CompletionStage<Result> getAccessToken(String url_accessToken) {

        System.out.println("url_accessToken:"+url_accessToken);
        WSClient ws = new WSClient();
        WSRequest request = ws.url(url_accessToken);
        return request
                .addHeader("Accept-Language", "en_US")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic QVFTZkdoYmFZYWVzVFhzWG85ODR0X1pwZmNPa093NVZ5VkxibG5NYm9HajVQR2FtZFI3NF9tOEQ4MjZLV3N2NDNCQjBUTTFzUDhiRFk3dWU6RUF3SWlPRGd1amcwM1ZLeVowdmZWZFo5a1lqSnJmQWtJeFhtaWEtQ0I4cFc1ZFRHWWJOQnNWSzFET1AzSU51OUZRX3NqU3BwWjVRS2dYYmw=")
                .post("grant_type=client_credentials")
                .thenApply((WSResponse x) -> {
                    if (x.getStatus() == 200) {
                        JsonNode jsonNode = Json.parse(x.getBody());
                        accessToken = jsonNode.get("access_token").toString();
                        return Results.ok("Access Token Success");

                    } else {
                        return Results.badRequest("Failed access token");

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

