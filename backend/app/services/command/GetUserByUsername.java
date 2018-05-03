package services.command;

import DAO.*;
import models.*;

public class GetUserByUsername implements DAOInterface {

	private User user;
    private String username; 
    UserDAO userDAO = new UserDAO();


    public void setUserByUsernameParams (String username) {
        this.username = username;
    }

    public void setUserByUsername (User user) {
        this.user = user;
    }

    public User getUserByUsername () {
        return this.user;
    }

    @Override
    public void execute() {
        setUserByUsername(userDAO.getUserByUsername(username));
    }
}