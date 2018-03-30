package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;
import java.util.List;
import java.util.ArrayList;
// import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name="users")
public class User extends Model {

    @Id
    public Long id;

    @Column(name = "username")
    @Constraints.Required
    public String username;

    @Column(name = "passwordHash")
    @Constraints.Required
    public String passwordHash;

    @Column(name = "securityQuestion")
    public String securityQuestion;

    @Column(name = "answer")
    public String answer;

    @Column(name = "userType")
    @Constraints.Required
    public String userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Mashup> mashups = new ArrayList<>();


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
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = password;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

//    public String encryptPassword(String unencryptedPassword) {
//        return BCrypt.hashpw(unencryptedPassword, BCrypt.gensalt());
//    }

    public static User authenticate(String userName, String password) {
        User user = User.find.query().where().eq("userName", userName).findUnique();
        if (user != null && password.equals(user.passwordHash)) {
//        if (user != null && BCrypt.checkpw(password, user.passwordHash)) {
//            TODO: use BCRYPT to authenticate.
            return user;
        } else {
            return null;
        }
    }

    public void setParameters(String username, String password, String securityQuestion, String answer) {
        this.username = username;
        this.passwordHash = password; //this.encryptPassword(password);
        this.securityQuestion = securityQuestion;
        this.answer = answer;
    }

    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append("\"id\": \"").append(this.getId()).append("\", ");
        json.append("\"username\": \"").append(this.getUsername()).append("\", ");
        json.append("\"type\": \"").append(this.getUserType()).append("\"}");
        return json.toString();
    }
}