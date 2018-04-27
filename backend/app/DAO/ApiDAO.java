package DAO;

import enums.NotificationType;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import services.apiBuilder.ApiBuilder;
import services.apiStates.ApiState;
import services.apiStates.ApiStates;
import services.apiStates.ApprovedApi;

import java.util.List;
import play.libs.Json;

public class ApiDAO implements DAOInterface{

    private HashMap<Long, List<Api>> categorizeApis (List<Api> apis) {
        HashMap<Long, List<Api>> apisHashMap = new HashMap<>();
        Iterator<Api> apiIterator = apis.iterator();

        while(apiIterator.hasNext()) {
            Api api = apiIterator.next();
            Long apiId = api.getId();
            List<Api> list = apisHashMap.get(apiId);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(api);
            apisHashMap.put(api.getId(), list);
        }
        return apisHashMap;
    }

    private Api getLatestVersionOfApi (List<Api> apis) {
        Api latestVersion = null;
        Iterator<Api> apiIterator = apis.iterator();
        while(apiIterator.hasNext()) {
            Api api = apiIterator.next();
            if (latestVersion != null) {
                int ver = latestVersion.getSubmissionVersion();
                if (ver < api.getSubmissionVersion()) latestVersion = api;
            } else {
                latestVersion = api;
            }
        }
        return latestVersion;
    }

    private Long getIdOfLatestVersionOfApi (List <Api> apis) {
        return getLatestVersionOfApi(apis).getDBId();
    }

    private List<Api> getLastVersionsOfApis (List<Api> apis) {
        HashMap<Long, List<Api>> apisHashMap = categorizeApis(apis);
        ApiBuilder apiBuilder = new ApiBuilder();
        List<Api> result = new ArrayList<>();
        for (Long key : apisHashMap.keySet()) {
            List<Api> apisByKey = apisHashMap.get(key);
            Long apiId = getIdOfLatestVersionOfApi(apisByKey);
            Api builtApi = apiBuilder.buildApi(apiId);
            result.add(builtApi);
        }
        return result;
    }

    public List<Api> getAll() {
        List<Api> apis = Api.find.query().fetch("user").findList();
        return getLastVersionsOfApis(apis);
    }

    public List<Api> getVersionsOfApi (int apiId) {
        return Api.find.query().where().eq("apiId", apiId).orderBy("submissionVersion").findList();
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

    public List<Api> getVersionsForApi(int apiId) {
        return Api.find.query().where().eq("apiId", apiId).orderBy("submissionVersion DESC").findList();
    }

    public Api getById(int apiId) {
        List<Api> apis = getVersionsOfApi(apiId);
        return apis.get(apis.size() - 1);
    }

    public List<Api> searchAPIs (String searchParam, String type) {
        List<Api> apis = Api.find.query().where()
                .like("name", "%" + searchParam + "%")
                .eq("apitype",type)
                .eq("state", ApiStates.APPROVED).findList();
        return getLastVersionsOfApis(apis);
    }

    public List<Api> searchAPIs (int userId) {
        List<Api> apis = Api.find.query().where().eq("user_id", userId).findList();
        return getLastVersionsOfApis(apis);
    }

    public Api getApiById(int id) {
        List<Api> apis = Api.find.query().fetch("user").where().eq("apiId", id).order("submissionVersion").findList();
        return apis.size() > 0 ? apis.get(apis.size() - 1) : null;
    }

    public String getCommentsForApi (int id) {
        List <ApiComments> comments = ApiComments.find.query().where().eq("apiid", id).findList();
        return Json.toJson(comments).asText();
    }

    public void approveApi (int apiId) {
        Api api = this.getApiById(apiId);
        ApiState state = new ApprovedApi();
        state.updateApiState(api);
        api.save();
        api.notifyAllFollowers(NotificationType.APPROVE_NOTIFICATION);
    }

  //USER DAO
  public String getAllUsers(){
    return null;
  }

  public User getUserByUserId(int userId){
    return null;
  }
  public User updateUserProfile(int userId, String name, String email, String phoneNumber, String notificationMethod){
    return null;
  }
  public User getUserByUsername(String username){
    return null;
  }
  public void ensureOneAdmin(){
  }

  //Log Message DAO
  public void writeSubmitApiLogMessage(String username, String name){
  }
  public List<LogMessage> getAllLogMessages(){
    return null;
  }
  public User createNewUser(String username, String password, String securityQuestion, String answer){
    return null;
  }
  public void writeSearchApiLogMessage(String username, String searchParam){
  }
  public void writeViewApiLogMessage(String username, String apiname){
    
  }
  public List<Mashup> getAllMashups(){
    return null;
  }
}
