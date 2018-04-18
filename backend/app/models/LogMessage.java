package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="log_message")
public class LogMessage extends Model {
    @Id
    public Long id;

    @Column(name = "date")
    @Constraints.Required
    public Date datetime;

    @Column(name = "message")
    @Constraints.Required
    public String message;

    public static final Finder<Long, LogMessage> find = new Finder<>(LogMessage.class);

    public LogMessage() {

    }

    public LogMessage(String message) {
        this.datetime = new Date();
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
