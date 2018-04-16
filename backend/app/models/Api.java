package models;

import javax.persistence.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.*;
import play.data.validation.*;

import play.libs.Json;
import services.apiStates.ApiState;
import services.apiStates.ApiStates;

import java.util.*;

import services.json.JsonVisitor;

@Entity
@Table(name="apis")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="apiType")
@DiscriminatorValue("api")
public class Api extends Model implements Cloneable {

    @Id
    public Long id;

    @Column(name = "name")
    @Constraints.Required
    public String name;

    @Column(name = "homepage")
    @Constraints.Required
    public String homepage;

    @Column(name = "endpoint", columnDefinition = "varchar(255) default ''")
    public String endpoint;

    @Column(name = "version", columnDefinition = "varchar(255) default ''")
    public String version;

    @Column(name = "scope", columnDefinition = "varchar(255) default ''")
    public String scope;

    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    public String description;

    @Column(name = "email", columnDefinition = "varchar(255) default ''")
    public String email;

    @Column(name = "state", columnDefinition = "varchar(255) default ''")
    public ApiStates state;

    @ManyToOne
    public User user;

    @ManyToMany(mappedBy = "apis", cascade = CascadeType.ALL)
    public List<Mashup> mashups = new ArrayList<>();

    @ManyToMany(mappedBy = "followedApis")
    public List<User> followers = new ArrayList<>();

    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL)
    public List<ApiComments> apiComments = new ArrayList<ApiComments>();

    public static final Finder<Long, Api> find = new Finder<>(Api.class);

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if(this.name != null) {
            return name;
        } else {
            return "";
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getHomepage() {
        if(this.homepage != null) {
            return homepage;
        } else {
            return "";
        }
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEndpoint() {
        if(this.endpoint != null) {
            return endpoint;
        } else {
            return "";
        }
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }


    public String getVersion() {
        if(this.version != null) {
            return version;
        } else {
            return "";
        }
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        if(this.scope != null) {
            return scope;
        } else {
            return "";
        }
    }
    public void setScope(String scope) {
        this.scope = scope;
    }


    public String getDescription() {
        if(this.description != null) {
            return description;
        } else {
            return "";
        }
    }
    public void setDescription(String apiDescription) {
        this.description = apiDescription;
    }


    public String getEmail() {
        if(this.email != null) {
            return email;
        } else {
            return "";
        }
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Mashup> getMashups() {
        return mashups;
    }

    public void setMashups(List<Mashup> mashups) {
        this.mashups = mashups;
    }

    public void setComments (List<ApiComments> comments) {
        this.apiComments = comments;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public ApiStates getState() {
        return state;
    }

    public void setState(ApiStates state) {
        this.state = state;
    }

    public void setParameters(String name, String homepage, String endpoint, String version, String scope, String description, String email) {
        this.name = name;
        this.homepage = homepage;
        this.endpoint = endpoint;
        this.version = version;
        this.scope = scope;
        this.description = description;
        this.email = email;
    }

    public ObjectNode toJson() {
        JsonVisitor jsonVisitor = new JsonVisitor();
        return jsonVisitor.visit(this);
    }

    public String toJsonWithComments (String commentsJson) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\"id\": \"").append(this.getId()).append("\",");
        sb.append("\"type\": \"").append("api").append("\",");
        sb.append("\"name\": \"").append(this.getName()).append("\",");
        sb.append("\"homepage\": \"").append(this.getHomepage()).append("\",");
        sb.append("\"endpoint\": \"").append(this.getEndpoint()).append("\",");
        sb.append("\"version\": \"").append(this.getVersion()).append("\",");
        sb.append("\"scope\": \"").append(this.getScope()).append("\",");
        sb.append("\"description\": \"").append(this.getDescription()).append("\",");
        sb.append("\"user\": \"").append(this.getUser()).append("\",");
        sb.append("\"comments\": ").append(commentsJson).append("\",");
        sb.append("\"state\": ").append(this.getState()).append("\"");
        sb.append("}");
        return sb.toString();
    }

    public void notifyAllFollowers(String activity) {
        for (User follower: followers) {
            follower.sendNotification(this, activity);
        }
    }
}