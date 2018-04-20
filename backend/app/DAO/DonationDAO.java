package DAO;

import models.Donation;

import java.math.BigInteger;
import java.time.Month;
import java.time.Year;
import java.util.List;

public class DonationDAO {

    public Donation createInvoice(String username, String cardnum, String month, String year, String sec, String amount, String payId) {
        Donation donation = new Donation();
        System.out.println("DAO:"+username + ":"+cardnum+ ":"+month + ":"+year + ":"+sec + ":"+amount + ":"+payId);
        donation.setParameters(username, cardnum, month, year, sec, amount,payId);
        donation.save();
        return donation;
    }
}