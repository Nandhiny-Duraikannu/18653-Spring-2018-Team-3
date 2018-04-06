package models;

import javax.persistence.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.*;
import play.data.validation.*;
import play.libs.Json;
import java.util.*;

@Entity
@Table(name="apis")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="apiType")
@DiscriminatorValue("api")
public class Api extends Model {

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

    @ManyToOne
    public User user;

    @ManyToMany(mappedBy = "apis", cascade = CascadeType.ALL)
    public List<Mashup> mashups = new ArrayList<>();

    public static final Finder<Long, Api> find = new Finder<>(Api.class);

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getHomepage() {
        return homepage;
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }


    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String apidescription) {
        this.description = description;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
        ObjectNode result = Json.newObject()
                .put("id", id)
                .put("type", "api")
                .put("name", name)
                .put("homepage", homepage)
                .put("endpoint", endpoint)
                .put("version", version)
                .put("scope", scope)
                .put("description", description)
                .put("user", user.username);
        return result;
    }

    public void notifyAllFollowers() {
        // TODO: dummy values for now, change to actual followers later
        List<User> followers = new ArrayList<>();
        followers.add(user);

        for (User follower: followers)
            follower.sendNotification(name);
    }
}