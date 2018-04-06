package DAO;

import models.*;
import java.util.*;

import services.*;

public class FollowerDAO {
    private UserDAO userDAO = new UserDAO();

    public List<Follower> getAll() {
        return Follower.find.all();
    }

    public List<User> getFollowers(int apiId) {
        List<Follower> followerModels = Follower.find.query().where().eq("api_id", apiId).findList();

        System.out.println("Number of follower models: " + String.valueOf(followerModels.size()));

        List<User> followers = new ArrayList<>();
        for (Follower followerModel: followerModels) {
            User follower = userDAO.getUserByUserId(Integer.valueOf(String.valueOf(followerModel.follower_id)));
            if (follower != null)
                followers.add(follower);
        }
        return followers;
    }
}