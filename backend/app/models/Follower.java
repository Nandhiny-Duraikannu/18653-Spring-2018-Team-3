package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;
import java.util.*;
import io.ebean.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.*;
import java.util.List;
import java.util.ArrayList;
import play.libs.Json;
// import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name="followers")
public class Follower extends Model {


    @Column(name = "api_id")
    @Constraints.Required
    public Long api_id;


    @Column(name = "follower_id")
    @Constraints.Required
    public Long follower_id;

    @Column(name = "submitter_id")
    @Constraints.Required
    public Long submitter_id;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // public List<Api> apis = new ArrayList<>();

    public static final Finder<Long, Follower> find = new Finder<>(Follower.class);

    // Getters and setters
    public Long getAPIId() {
        return api_id;
    }

    public void setAPIId(Long api_id) {
        this.api_id = api_id;
    }

    public Long getFollowerId() {
        return follower_id;
    }

    public void setFollowerId(Long follower_id) {
        this.follower_id = follower_id;
    }

     public Long getSubmitterId() {
        return submitter_id;
    }

    public void setSubmitterId(Long submitter_id) {
        this.submitter_id = submitter_id;
    }

    public void setParameters(Long follower_id, Long api_id,  Long submitter_id) {
        this.api_id = api_id;
        this.follower_id = follower_id;
        this.submitter_id = submitter_id;
    }

  

    // public void addApi(Api api) {
    //     apis.add(api);
    // }

    public ObjectNode toJson() {
        ObjectNode result = Json.newObject()
                .put("follower_id", follower_id)
                .put("api_id", api_id)
                .put("submitter_id", submitter_id);
        return result;
    }
}