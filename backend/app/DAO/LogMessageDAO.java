package DAO;

import enums.LoggerType;
import models.*;
import services.logger.*;

import java.util.List;

public class LogMessageDAO implements DAOInterface {

    AbstractLogger loggerChain = LoggerChain.getLoggerChain();

    public List<LogMessage> getAllLogMessages() {
        return LogMessage.find.all();
    }

    private LogMessage writeLogMessage(LoggerType loggerType, String username, String apiName) {
        String message = loggerChain.logMessage(loggerType, username, apiName);
        LogMessage logMessage = new LogMessage(message);
        logMessage.save();
        return logMessage;
    }

    public void writeSubmitApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.SUBMIT_API_LOGGER, username, apiName);
    }

    public void writeSearchApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.SEARCH_API_LOGGER, username, apiName);
    }

    public void writeUpdateApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.UPDATE_API_LOGGER, username, apiName);
    }

    public void writeViewApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.VIEW_API_LOGGER, username, apiName);
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
  public User createNewUser(String username, String password, String securityQuestion, String answer){
    return null;
  }
  public List<Mashup> getAllMashups(){
    return null;
  }

}
