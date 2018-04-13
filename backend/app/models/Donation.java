package models;

import javax.persistence.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.*;
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

    @Column(name = "invoiceid")
    @Constraints.Required
    public String invoiceid;

   
    public static final Finder<Long, Donation> find = new Finder<>(Donation.class);

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getinvoiceID() {
        return this.invoiceid;
    }

    public void setinvoiceID(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    
    public void setParameters(String username, String invoiceid) {
        this.username = username;
        this.invoiceid = invoiceid;
    }

    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append("\"username\": \"").append(this.getUsername()).append("\", ");
        json.append("\"invoiceid\": \"").append(this.getinvoiceID()).append("\"}");
        return json.toString();
    }

}