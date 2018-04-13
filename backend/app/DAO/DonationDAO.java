package DAO;

import models.Donation;
import java.util.List;

public class DonationDAO {

    public Donation createInvoice(String username, String invoiceid) {
        Donation donation = new Donation();
        donation.setParameters(username, invoiceid);
        donation.save();
        return donation;
    }
}