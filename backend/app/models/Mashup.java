package models;

import com.fasterxml.jackson.databind.node.ArrayNode;
import io.ebean.*;
import javax.persistence.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import services.json.JsonVisitor;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("mashup")
public class Mashup extends Api {

    @Column(name="date")
    public Date updatedAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mashup_apis",
            joinColumns=@JoinColumn(name="mashup_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="api_id", referencedColumnName="id"))
    public List<Api> apis = new ArrayList<>();

    @ManyToMany(mappedBy = "followedApis")
    public List<User> followers = new ArrayList<>();

    public static final Finder<Long, Mashup> find = new Finder<>(Mashup.class);

    public void addApi(Api api) {
        apis.add(api);
    }

    public List<Api> getApis() {
        return apis;
    }

    public ObjectNode toJson() {
        JsonVisitor jsonVisitor = new JsonVisitor();
        return jsonVisitor.visit(this);
    }
}
