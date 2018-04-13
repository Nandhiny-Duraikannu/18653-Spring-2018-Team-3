package controllers;

import DAO.DonationDAO;
import models.Donation;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

public class DonationController extends Controller {

    private final FormFactory formFactory;

    private DonationDAO donationDAO = new DonationDAO();

    @Inject
    public DonationController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

     public Result donate() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = form.get("username");
        String invoiceid = form.get("invoiceid");

        Donation donate = donationDAO.createInvoice(username, invoiceid);
        return ok(donate.toJSON());
    }

}