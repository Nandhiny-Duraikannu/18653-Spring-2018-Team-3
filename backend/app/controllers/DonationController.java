package controllers;

import DAO.DonationDAO;
import models.Donation;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;
import services.proxy.*;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.math.BigInteger;
import java.time.Year;
import play.mvc.Results;
import javax.inject.Inject;
import java.time.Month;


public class DonationController extends Controller {

    private final FormFactory formFactory;
    private final WSClient ws;
    private DonationDAO donationDAO = new DonationDAO();

    @Inject
    public DonationController(WSClient ws, FormFactory formFactory) {
        this.formFactory = formFactory;
        this.ws = ws;
    }

    public CompletionStage<Result> donate() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = form.get("username");
        String cardnum = form.get("cardnum");
        String month = form.get("month");
        String year = form.get("year");
        String cvv = form.get("sec");
        String amount = form.get("amount");
        String accessToken  = form.get("accessToken");

        System.out.println("accessToken in backend donation controller"+accessToken);
        //proxy design pattern
        paymentInterface proxy = new paymentPaypal(ws);
       String paymentId = proxy.submitPayment(username, cardnum, month, year, cvv, amount,accessToken).toString();

        WSRequest request = ws.url("https://api.sandbox.paypal.com/v1/payments/payment");
        return request
                    .addHeader("Content-Type", "application/json")
                    .post(" ")
                    .thenApply((WSResponse r) -> {
                        return ok(paymentId);

                    });


    }

}