package services.proxy;

import java.math.BigInteger;
import java.time.Month;
import java.time.Year;

public interface paymentInterface {
        String payment(String username, String cardnum, String month, String year, String cvv, String amount );
}
