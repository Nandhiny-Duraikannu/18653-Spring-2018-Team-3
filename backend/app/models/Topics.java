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
import services.message.*;

@Entity
@Table(name="topics")
public class Topics extends Model {

    @Column(name = "username")
    @Constraints.Required
    public String username;

    @Column(name = "apiname")
    @Constraints.Required
    public String apiname;

    @Column(name = "topicname")
    @Constraints.Required
    public String topicname;

   

    public static final Finder<Long, Topics> find = new Finder<>(Topics.class);

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    

    public void setParameters(String username, String apiname, String topicname) {
        this.username = username;
        this.apiname = apiname;
        this.topicname = topicname;
    }

    // public String profileToJson() {
    //     StringBuffer json = new StringBuffer();
    //     json.append("{");
    //     json.append("\"id\": \"").append(this.getId()).append("\", ");
    //     json.append("\"username\": \"").append(this.getUsername()).append("\", ");
    //     json.append("\"name\": \"").append(this.getName()).append("\", ");
    //     json.append("\"email\": \"").append(this.getEmail()).append("\", ");
    //     json.append("\"phoneNumber\": \"").append(this.getPhoneNumber()).append("\", ");
    //     json.append("\"notificationMethod\": \"").append(this.getNotificationMethod()).append("\"}");
    //     return json.toString();
    // }

    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");

        json.append("\"username\": \"").append(this.getUsername()).append("\", ");
        json.append("\"topicname\": \"").append(this.getTopicname()).append("\", ");
        json.append("\"apiname\": \"").append(this.getApiname()).append("\"}");
        return json.toString();
    }

}