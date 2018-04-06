package models;

import io.ebean.*;
import play.data.validation.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class ApiComments extends Model {

    @Id
    public Long id;

    @Column(name = "apiId")
    @Constraints.Required
    public int apiId;

    @Column(name = "comment")
    @Constraints.Required
    public String comment;

    @ManyToOne
    public Api api;

    public static final Finder<Long, ApiComments> find = new Finder<>(ApiComments.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getComment() {
        if (comment != null) {
            return comment;
        } else {
            return "";
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public String toJson () {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("\"comment\": \"" + this.getComment() + "\"");
        result.append("}");
        return result.toString();
    }
}