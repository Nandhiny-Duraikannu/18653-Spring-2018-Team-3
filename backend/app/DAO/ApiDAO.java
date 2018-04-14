package DAO;

import models.*;
import java.util.List;

import services.*;

public class ApiDAO {

    public List<Api> getAll() {
        return Api.find.query().fetch("user").findList();
    }

    public Api getById(int apiId) {
        return Api.find.query().where().eq("id", apiId).findUnique();
    }

    public List<Api> searchAPIs (String searchParam, String type) {
        return Api.find.query().where().like("name", "%" + searchParam + "%").eq("apitype",type).findList();
    }

    public List<Api> searchAPIs (int userId) {
        return Api.find.query().where().eq("user_id", userId).findList();
    }

    public Api getApiById(int id) {
        return Api.find.query().fetch("user").where().eq("id", id).findUnique();
        //.fetch("user")
    }

    public String getCommentsForApi (int id) {
        List <ApiComments> comments = ApiComments.find.query().where().eq("apiid", id).findList();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < comments.size(); i++) {
            sb.append(comments.get(i).toJson());
            if (i != (comments.size() - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
