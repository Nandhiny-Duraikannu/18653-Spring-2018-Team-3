package controllers;

import DAO.DonationDAO;
import models.Donation;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;
import services.proxy.*;
import play.libs.ws.*;

import java.math.BigInteger;
import java.time.Year;

import javax.inject.Inject;
import java.time.Month;

public class DonationController extends Controller {

    private final FormFactory formFactory;
   //private final WSClient ws;

    private DonationDAO donationDAO = new DonationDAO();

    @Inject
    public DonationController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

     public Result donate() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = form.get("username");
        String cardnum = form.get("cardnum");
         String month = form.get("month");
         String year = form.get("year");
         String cvv = form.get("sec");
         String amount = form.get("amount");

         //proxy design pattern
         paymentInterface proxy = new paymentPaypal();
         String payId = proxy.payment(username,cardnum,month,year,cvv,amount);
         System.out.println("saved:"+username + ":"+cardnum+ ":"+month + ":"+year + ":"+cvv + ":"+amount + ":"+payId);
        Donation donate = donationDAO.createInvoice(username, cardnum, month,year,cvv,amount,payId );
        return ok(donate.toJSON());
    }

}