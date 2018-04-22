package services.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import services.apiStates.ApiStates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonVisitor {
    private ObjectNode getJson(Api api) {
        User user = api.getUser();
        String username = (user == null) ? "" : user.getUsername();
        if (username == null) username = "";

        List<JsonNode> followersList = new ArrayList<>();
        for (User follower: api.getFollowers()) {
            followersList.add(follower.toFollowerJson());
        }

        boolean status = api.getState() == ApiStates.APPROVED ? true : false;

        Date date = api.getUpdatedAt();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        String apiDate = df.format(date);

        ObjectNode result = Json.newObject()
                .put("id", api.getId())
                .put("type", "api")
                .put("name", api.getName())
                .put("homepage", api.getHomepage())
                .put("endpoint", api.getEndpoint())
                .put("version", api.getVersion())
                .put("scope", api.getScope())
                .put("description", api.getDescription())
                .put("approved", status)
                .put("date", apiDate)
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
