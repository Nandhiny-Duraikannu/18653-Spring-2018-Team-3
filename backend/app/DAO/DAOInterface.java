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

public interface DAOInterface {

	//USER DAO
	public String getAllUsers();
	public User createNewUser(String username, String password, String securityQuestion, String answer);
	public User getUserByUserId(int userId);
	public User updateUserProfile(int userId, String name, String email, String phoneNumber, String notificationMethod);
	public User getUserByUsername(String username);
	public void ensureOneAdmin();

	//API DAO	
	public List<Api> getVersionsForApi(int apiId);
	public void approveApi(int apiId);
	public Api getById(int apiID);
	public List<Api> getAll();
	public List<Api> searchAPIs(int userId);
	public List<Api> searchAPIs(String searchParam, String type);
	public Api getApiById(int id);


	//Log Message DAO
	public void writeSubmitApiLogMessage(String username, String name);
	public List<LogMessage> getAllLogMessages();
	public void writeSearchApiLogMessage(String username, String searchParam);
	public void writeViewApiLogMessage(String username, String apiname);

	//Mashup DAO
	public List<Mashup> getAllMashups();

}