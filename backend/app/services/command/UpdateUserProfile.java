package services.command;

import DAO.*;
import models.*;

public class UpdateUserProfile implements DAOInterface {

	private User user;
    private String username; 
    private int userId; 
    private String email;
    private String phoneNumber;
    private String notificationMethod;
    UserDAO userDAO = new UserDAO();


    public  void setUpdateUserProfileParams (int userId, String name, String email, String phoneNumber, String notificationMethod) {
        this.username = name;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notificationMethod = notificationMethod;
    }

    public void setUpdateUserProfile (User user) {
        this.user = user;
    }

    public User getUpdateUser () {
        return this.user;
    }

    @Override
    public void execute() {
        setUpdateUserProfile(userDAO.updateUserProfile (userId, username, email, phoneNumber, notificationMethod));
    }
}