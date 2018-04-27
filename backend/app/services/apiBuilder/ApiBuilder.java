package services.apiBuilder;

import DAO.ApiDAO;
import DAO.UserDAO;
import models.Api;
import models.Mashup;
import models.User;

public class ApiBuilder {
    private ApiDAO apiDAO;
    private UserDAO userDAO;

    public ApiBuilder () {
        this.apiDAO = new ApiDAO();
        this.userDAO = new UserDAO();
    }

    public Api buildApi (Long apiId) {
//        Api api = apiDAO.getApiById(Integer.valueOf(apiId.toString()));
        // TODO:
        Api api = Api.find.query().fetch("user").where().eq("id", apiId).findOne();
        Long userId = api.getUser().getId();
        User user = userDAO.getUserByUserId(Integer.valueOf(userId.toString()));
        api.setUser(user);

        return api;
    }
}
