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

    @Column(name = "id")
    @Constraints.Required
    public int id;

    @Column(name = "apiname")
    @Constraints.Required
    public String apiname;

    @Column(name = "topicname")
    @Constraints.Required
    public String topicname;

   

    public static final Finder<Long, Topics> find = new Finder<>(Topics.class);


    // Getters and setters

    public int getUserID() {
        return id;
    }

    public void setUserID(int id) {
        this.id = id;
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

    

    public void setParameters(int id, String apiname, String topicname) {
        this.id = id;
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
    public static String deleteUser(int id) {
        System.out.println("User id : "+id);
        SqlUpdate tangoDown = Ebean.createSqlUpdate("DELETE FROM topics WHERE id = id");
        tangoDown.setParameter(":id", id);
        tangoDown.execute();
        return "Cleared 'topics' table";
            // List<Topics> topics = Topics.find.query().where().eq("id",id).findList();
            // if(topics.size() <= 0 ) {
            //     return "No records exists";
            // } else {
            //     for(Topics topic : topics)
            //         topic.delete();
            //     return "Cleared 'topics' table";
            // }
    }


    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");

        json.append("\"id\": \"").append(this.getUserID()).append("\", ");
        json.append("\"topicname\": \"").append(this.getTopicname()).append("\", ");
        json.append("\"apiname\": \"").append(this.getApiname()).append("\"}");
        return json.toString();
    }

}