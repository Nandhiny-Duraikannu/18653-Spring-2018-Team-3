package DAO;

import models.*;

import java.util.List;

import play.libs.Json;

public class ApiDAO {

    public List<Api> getAll() {
        return Api.find.query().fetch("user").findList();
    }

    public List<Api> getVersionsOfApi (int apiId) {
        return Api.find.query().where().eq("id", apiId).orderBy("submissionVersion").findList();
    }

    public Long getNextId () {
        List<Api> apis = Api.find.query().order("id").findList();
        if (apis.size() == 0) {
            return Long.valueOf("1");
        } else {
            return apis.get(apis.size() - 1).getDBId() + 1;
        }
    }

    public Api getApiByIdAndVersion(int apiId, int versionId) {
        return Api.find.query().where().eq("id", apiId).eq("submissionVersion", versionId).findUnique();
    }

    public Api getById(int apiId) {
        List<Api> apis = getVersionsOfApi(apiId);
        return apis.get(apis.size() - 1);
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
        return Json.toJson(comments).asText();
    }
}
