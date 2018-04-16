package services.proxy;

import java.math.BigInteger;
import java.time.Month;
import java.time.Year;

public class paymentPaypal implements paymentInterface {

    @Override
    public String payment(String username, String cardnum, String month, String year, String cvv,String amount){

        System.out.println("test in class");
        String payId = "payidtest";
        return payId;


    }

}

