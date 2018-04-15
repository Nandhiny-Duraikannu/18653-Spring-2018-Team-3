package services.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

public class JsonVisitor {
    private ObjectNode getJson(Api api) {
        String username = api.getUser().getUsername();
        if (username == null) username = "";

        List<JsonNode> followersList = new ArrayList<>();
        for (User follower: api.getFollowers()) {
            followersList.add(follower.toFollowerJson());
        }

        ObjectNode result = Json.newObject()
                .put("id", api.getId())
                .put("type", "api")
                .put("name", api.getName())
                .put("homepage", api.getHomepage())
                .put("endpoint", api.getEndpoint())
                .put("version", api.getVersion())
                .put("scope", api.getScope())
                .put("description", api.getDescription())
                .put("user", username);
        result.put("followers", Json.toJson(followersList));
        return result;
    }

    public ObjectNode visit(Api api) {
        return getJson(api);
    }

    public ObjectNode visit(Mashup mashup) {
        ObjectNode result = getJson(mashup);
        result.put("type", "mashup")
                .put("id", mashup.getId());

        ArrayNode apiIds = result.putArray("apis");
        for (Api api: mashup.getApis()) {
            apiIds.add(api.getId());
        }

        return result;
    }
}
