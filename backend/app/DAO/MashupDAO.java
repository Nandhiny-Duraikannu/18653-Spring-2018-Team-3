package DAO;

import models.*;

import java.util.List;

public class MashupDAO implements DAOInterface {

    public List<Mashup> getAllMashups() {
        return Mashup.find.query().findList();
    }

    public List<Mashup> searchMashups (String searchParam, String type) {
        return Mashup.find.query().where().like("name", "%" + searchParam + "%").eq("apitype",type).findList();
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

  //API DAO 
  public List<Api> getVersionsForApi(int apiId){
    return null;
  }
  public void approveApi(int apiId){
  }
  public Api getById(int apiID){
    return null;
  }
  public List<Api> getAll(){
    return null;
  }
  public List<Api> searchAPIs(int userId){
    return null;
  }
  public List<Api> searchAPIs(String searchParam, String type){
    return null;
  }
  public Api getApiById(int id){
    return null;
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
}
