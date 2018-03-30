package models;

import io.ebean.*;
import play.data.validation.Constraints;
import javax.persistence.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

@Entity
@Table(name="mashups")
public class Mashup extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String url;

    public String description;

    @ManyToOne
    public User user;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "mashup_apis")
//    public List<Api> apis;

    public static final Finder<Long, Mashup> find = new Finder<>(Mashup.class);

    public void setParameters(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public JsonNode toJson() {
        ObjectNode result = Json.newObject();
        result.put("name", name);
        result.put("url", url);
        result.put("description", description);
        result.put("user", user.username);
        return Json.toJson(result);
    }
}
