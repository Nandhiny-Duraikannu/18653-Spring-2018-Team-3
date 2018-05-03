package services.command;

import DAO.*;
import models.*;

public class CreateNewUser implements DAOInterface {

	private User user;
    private String username; 
    private String password;
    private String securityQuestion;
    private String answer;
    UserDAO userDAO = new UserDAO();

    public void setCreateNewUserParams (String username, String password, String securityQuestion, String answer) {
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
    }

    public void setCreateNewUser (User user) {
        this.user = user;
    }

    public User getCreateNewUser () {
        return this.user;
    }

    @Override
    public void execute() {
        setCreateNewUser(userDAO.createNewUser(username, password, securityQuestion, answer));
    }
}