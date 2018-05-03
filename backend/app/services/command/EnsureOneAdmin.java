package services.command;

import DAO.*;

public class EnsureOneAdmin implements DAOInterface {

	UserDAO userDAO = new UserDAO();

    @Override
    public void execute() {
        userDAO.ensureOneAdmin();
    }
}