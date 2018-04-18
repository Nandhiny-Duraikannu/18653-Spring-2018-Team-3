package services.proxy;

import java.math.BigInteger;
import java.time.Month;
import java.time.Year;
import play.mvc.Result;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;



public interface paymentInterface {
        CompletionStage<Result> submitPayment(String username, String cardnum, String month, String year, String cvv, String amount, String accessToken);
}
