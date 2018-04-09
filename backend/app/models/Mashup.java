package models;

import com.fasterxml.jackson.databind.node.ArrayNode;
import io.ebean.*;
import javax.persistence.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("mashup")
public class Mashup extends Api {

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

    @Override
    public ObjectNode toJson() {
        ObjectNode result = super.toJson().put("type", "mashup")
                .put("id", this.id);
        ArrayNode apiIds = result.putArray("apis");
        for (Api api: apis) {
            apiIds.add(api.id);
        }
        return result;
    }
}
