package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.libs.Json;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="messages")
public class Message extends Model {
    @Id
    public Long id;

    @Column(name = "title")
    public String title;

    @Column(name = "content")
    @Constraints.Required
    public String content;

    @ManyToOne
    public User sender;

    @ManyToOne
    public User receiver;

    @Column(name = "date")
    @Constraints.Required
    public Date datetime;

    public static final Finder<Long, Message> find = new Finder<>(Message.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Message() {

    }

    public Message(User sender, User receiver, String title, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.content = content;
        this.datetime = new Date();
    }

    public ObjectNode toJson() {
        ObjectNode result = Json.newObject()
                .put("id", id)
                .put("sender", sender.username)
                .put("receiver", receiver.username)
                .put("title", title)
                .put("content", content)
                .put("datetime", datetime.toString());
        return result;
    }


}
