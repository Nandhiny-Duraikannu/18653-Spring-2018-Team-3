package models;

import javax.persistence.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.*;

import java.math.BigInteger;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.ArrayList;

import play.libs.Json;
import services.notification.*;

@Entity
@Table(name="donations")
public class Donation extends Model {

    // @Id
    // public Long id;

    @Column(name = "username")
    @Constraints.Required
    public String username;

    @Column(name = "cardnum")
    @Constraints.Required
    public String cardnum;

    @Column(name = "month")
    @Constraints.Required
    public String month;

    @Column(name = "year")
    @Constraints.Required
    public String year;

    @Column(name = "cvv")
    @Constraints.Required
    public String cvv;

    @Column(name = "amount")
    @Constraints.Required
    public String amount;

    @Column(name = "payId")
    public String payId;

    public static final Finder<Long, Donation> find = new Finder<>(Donation.class);

//    public Donation(String username, String cardnum, String month, String year, String sec, String amount, String payId) {
//    }

    public Donation() {

    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getcardnum() {
        return this.cardnum;
    }

    public void setcardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getcvv() {
        return this.cvv;
    }

    public void setcvv(String cvv) {
        this.cvv = cvv;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayId() {
        return this.payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    
    public void setParameters(String username, String cardnum, String month, String year, String cvv, String amount, String payId) {
        this.username = username;
        this.cardnum = cardnum;
        this.month = month;
        this.year = year;
        this.cvv = cvv;
        this.amount = amount;
        this.payId = payId;
    }

    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append("\"username\": \"").append(this.getUsername()).append("\", ");
        json.append("\"cardnum\": \"").append(this.getcardnum()).append("\", ");
        json.append("\"month\": \"").append(this.getMonth()).append("\", ");
        json.append("\"year\": \"").append(this.getYear()).append("\", ");
        json.append("\"cvv\": \"").append(this.getcvv()).append("\", ");
        json.append("\"amount\": \"").append(this.getAmount()).append("\", ");
        json.append("\"payId\": \"").append(this.getPayId()).append("\"}");
        return json.toString();
    }

}