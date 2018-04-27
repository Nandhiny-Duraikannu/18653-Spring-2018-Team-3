package DAO;

import models.*;

import java.util.List;

public class MessageDAO implements DAOInterface {

    public List<Message> getReceivedMessages(User receiver) {
        return Message.find.query()
                .fetch("sender")
                .fetch("receiver")
                .where()
                .eq("receiver_id", receiver.getId())
                .orderBy("datetime desc")
                .findList();
    }

    public Message create(User sender, User receiver, String title, String content) {
        Message message = new Message(sender, receiver, title, content);
        message.save();
        return message;
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
  public List<Mashup> getAllMashups(){
    return null;
  }
}
