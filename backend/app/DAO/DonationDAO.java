package DAO;

import models.*;

import java.math.BigInteger;
import java.time.Month;
import java.time.Year;
import java.util.List;

public class DonationDAO implements DAOInterface {

    public Donation createInvoice(String username, String cardnum, String month, String year, String sec, String amount, String payId) {
        Donation donation = new Donation();
        System.out.println("DAO:"+username + ":"+cardnum+ ":"+month + ":"+year + ":"+sec + ":"+amount + ":"+payId);
        donation.setParameters(username, cardnum, month, year, sec, amount,payId);
        donation.save();
        return donation;
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