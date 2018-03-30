package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;

@Entity
@Table(name="api")
public class Api extends Model {

    @Id
    public Long id;

    @Column(name = "apiname")
    @Constraints.Required
    public String apiname;

    @Column(name = "apihomepage")
    @Constraints.Required
    public String apihomepage;


    @Column(name = "apiendpoint")
    public String apiendpoint;

    @Column(name = "version")
    public String version;

    @Column(name = "scope")
    public String scope;

    @Column(name = "apidescription")
    public String apidescription;

    @Column(name = "emailaddress")
    public String emailaddress;

    @ManyToOne
    public User user;

    public String objectType;

    public static final Finder<Long, Api> find = new Finder<>(Api.class);

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public String getApiHomepage() {
        return apihomepage;
    }

    public void setApiHomepage(String apihomepage) {
        this.apihomepage = apihomepage;
    }



    public String apiendpoint() {
        return apiendpoint;
    }

    public void apiendpoint(String apiendpoint) {
        this.apiendpoint = apiendpoint;
    }


    public String version() {
        return version;
    }
    public void version(String version) {
        this.version = version;
    }

    public String scope() {
        return scope;
    }
    public void scope(String scope) {
        this.scope = scope;
    }


    public String apidescription() {
        return apidescription;
    }
    public void apidescription(String apidescription) {
        this.apidescription = apidescription;
    }


    public String emailaddress() {
        return emailaddress;
    }
    public void emailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }


    public String getObjectType() {
        return objectType;
    }
    public void setObjectType(String objectType) {

        this.objectType = objectType;
    }

    public void setParameters(String apiname, String apihomepage, String apiendpoint, String version, String scope, String apidescription, String emailaddress) {
        this.apiname = apiname;
        this.apihomepage = apihomepage;
        this.apiendpoint = apiendpoint;
        this.version = version;
        this.scope = scope;
        this.apidescription = apidescription;
        this.emailaddress = emailaddress;
    }

    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{");
        json.append("\"id\": \"").append(this.getId()).append("\", ");
        json.append("\"apiname\": \"").append(this.getApiname()).append("\", ");
        json.append("\"apiendpoint\": \"").append(this.apiendpoint()).append("\", ");
        json.append("\"version\": \"").append(this.version()).append("\", ");
        json.append("\"scope\": \"").append(this.scope()).append("\", ");
        json.append("\"apidescription\": \"").append(this.apidescription()).append("\", ");
        json.append("\"emailaddress\": \"").append(this.emailaddress()).append("\"}");
        return json.toString();

    }
}