package models;

import javax.persistence.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import enums.NotificationType;
import enums.UserType;
import io.ebean.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.*;
import java.util.List;
import java.util.ArrayList;

import play.libs.Json;
import services.notification.*;
import services.message.*;

@Entity
@Table(name="users")
public class User extends Model {

    @Id
    public Long id;

    @Column(name = "username")
    @Constraints.Required
    public String username;

    @Column(name = "name")
    @Constraints.Required
    public String name;

    @Column(name = "passwordHash")
    @Constraints.Required
    public String passwordHash;

    @Column(name = "securityQuestion")
    public String securityQuestion;

    @Column(name = "answer")
    public String answer;

    @Column(name = "userType")
    @Constraints.Required
    public UserType userType;

    @Column(name = "phoneNumber")
    public String phoneNumber;

    @Column(name = "email")
    public String email;

    @Column(name = "notificationMethod")
    public String notificationMethod;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Api> apis = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "api_followers",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="api_id", referencedColumnName="id"))
    public List<Api> followedApis = new ArrayList<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    public List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    public List<Message> receivedMessages = new ArrayList<>();

    public static final Finder<Long, User> find = new Finder<>(User.class);

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = this.encryptPassword(password);
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        if (this.phoneNumber != null) {
            return this.phoneNumber;
        } else {
            return "";
        }
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() {
        if (this.email != null) {
            return this.email;
        } else {
            return "";
        }
    }

    public void setEmail(String email) { this.email = email; }

    public String getNotificationMethod() {
        if (this.notificationMethod != null) {
            return this.notificationMethod;
        } else {
            return "";
        }
    }

    public void setNotificationMethod(String notificationMethod) { this.notificationMethod = notificationMethod; }

    public String getName() {
        if (this.name != null) {
            return name;
        } else {
            return "";
        }
    }

    public void setName(String name) { this.name = name; }


    public String encryptPassword(String unencryptedPassword) {
        return BCrypt.hashpw(unencryptedPassword, BCrypt.gensalt());
    }

    public boolean authenticate(String password) {
        if (BCrypt.checkpw(password, this.passwordHash)) {
            return true;
        } else {
            return false;
        }
    }

    public void setParameters(String username, String password, String securityQuestion, String answer) {
        this.username = username;
        this.setPasswordHash(password);
        this.securityQuestion = securityQuestion;
        this.answer = answer;
    }

    public void updatePassword(String password) {
        this.setPasswordHash(password);
        this.save();
    }

    public void addApi(Api api) {
        apis.add(api);
    }

    public List<Api> getApis() {
        return apis;
    }

    public void setApis(List<Api> apis) {
        this.apis = apis;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public boolean isFollowingApi(Api api) {
        for (Api a: followedApis) {
            if (a.getId() == api.getId())
                return true;
        }
        return false;
    }

    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append("\"id\": \"").append(this.getId()).append("\", ");
        json.append("\"username\": \"").append(this.getUsername()).append("\", ");
        json.append("\"type\": \"").append(this.getUserType()).append("\", ");
        json.append("\"securityQuestion\": \"").append(this.getSecurityQuestion()).append("\", ");
        json.append("\"answer\": \"").append(this.getAnswer()).append("\"}");
        return json.toString();
    }

    public ObjectNode toFollowerJson() {
        ObjectNode result = Json.newObject();
        result.put("id", id);
        result.put("username", username);
        return result;
    }

    public String profileToJson() {
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append("\"id\": \"").append(this.getId()).append("\", ");
        json.append("\"username\": \"").append(this.getUsername()).append("\", ");
        json.append("\"name\": \"").append(this.getName()).append("\", ");
        json.append("\"email\": \"").append(this.getEmail()).append("\", ");
        json.append("\"phoneNumber\": \"").append(this.getPhoneNumber()).append("\", ");
        json.append("\"notificationMethod\": \"").append(this.getNotificationMethod()).append("\"}");
        return json.toString();
    }

    public Message sendMessage(User receiver, String title, String content) {
        ChatRoom chatRoom = new MessageChatRoom();
        return chatRoom.send(this, receiver, title, content);
    }

    public void sendNotification(Api api, NotificationType notificationType) {
        if (notificationMethod == null || notificationMethod.equals("email")) {
            SendNotificationAPI notificationApi = new SendEmailNotification(api.getName(), email, notificationType);
            notificationApi.send(api.getUser(), this, "", "");
        } else if (notificationMethod.equals("phone")) {
            SendNotificationAPI notificationApi = new SendPhoneNotification(api.getName(), phoneNumber, notificationType);
            notificationApi.send(api.getUser(), this, "", "");
        } else if (notificationMethod.equals("text")) {
            SendNotificationAPI notificationApi = new SendTextNotification(api.getName(), phoneNumber, notificationType);
            notificationApi.send(api.getUser(), this, "", "");
        }
    }

}