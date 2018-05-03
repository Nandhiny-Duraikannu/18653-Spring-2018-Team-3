package services.command;

import DAO.*;
import models.*;

public class GetUserByUserId implements DAOInterface {

	private User user;
    private int id; 
    UserDAO userDAO = new UserDAO();

    public void setUserByUserIdParams (int id) {
        this.id = id;
    }

    public void setUserByUserId (User user) {
        this.user = user;
    }

    public User getUserByUserId () {
        return this.user;
    }

    @Override
    public void execute() {
        setUserByUserId(userDAO.getUserByUserId(id));
    }
}