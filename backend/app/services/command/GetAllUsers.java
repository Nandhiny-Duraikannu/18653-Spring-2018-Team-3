package services.command;

import DAO.*;

public class GetAllUsers implements DAOInterface {

	private String users;
    UserDAO userDAO = new UserDAO();

    public void setAllUsers (String users) {
        this.users = users;
    }

    public String getAllUsers () {
        return this.users;
    }

    @Override
    public void execute() {
        String users = userDAO.getAllUsers();
        setAllUsers(users);
    }
}