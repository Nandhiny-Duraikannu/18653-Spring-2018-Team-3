package DAO;

import models.*;
import enums.UserType;
import services.factories.*;

import java.util.Iterator;
import java.util.List;

public class UserDAO implements DAOInterface {
    private AbstractFactory userFactory = FactoryProducer.getFactory("user");

    public User createNewUser(String username, String password, String securityQuestion, String answer) {
        UserFactory userFactory = new UserFactory();
        User user = userFactory.getUser(UserType.STANDARD_USER);
      
        user.setParameters(username, password, securityQuestion, answer);
        user.save();
        return user;
    }

    public void ensureOneAdmin () {
        UserFactory userFactory = new UserFactory();
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("usertype", UserType.ADMIN_USER).findUnique();
            if (user == null) {
                userDB = userFactory.getUser(UserType.ADMIN_USER);
                userDB.setUsername("admin");
                userDB.setPasswordHash("admin");
                userDB.setSecurityQuestion("car");
                userDB.setAnswer("admin");
                userDB.setName("Administrator");
                userDB.save();
            } else {
                System.out.println("The admin already exists.");
            }
        } catch (Exception e) {
            System.out.println("There was an error checking for the admin.");
        }
    }

    public User getUserByUsername(String username) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("username", username).findUnique();
            if (user == null) {
                return null;
            } else {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByUserId (int id) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("id", id).findUnique();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAllUsers () {
        User userDB = new User();
        List<User> users = userDB.find.all();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        String comma = "";

        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User currentUser = userIterator.next();
            stringBuffer.append(comma);
            comma = ", ";
            stringBuffer.append(currentUser.toJSON());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public User updateUserProfile (int userId, String name, String email, String phoneNumber, String notificationMethod) {
        User userDB = new User();
        try {
            User user = userDB.find.query().where().eq("id", userId).findUnique();
            if (user == null) {
                return null;
            } else {
                user.setName(name);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setNotificationMethod(notificationMethod);
                user.save();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
  public void writeSearchApiLogMessage(String username, String searchParam){

    }
  public void writeViewApiLogMessage(String username, String apiname){

    }
public List<Mashup> getAllMashups(){
    return null;
  }
}
