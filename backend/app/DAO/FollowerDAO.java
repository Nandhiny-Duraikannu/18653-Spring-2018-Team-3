package DAO;

import models.*;
import java.util.List;

import services.*;

public class FollowerDAO {

    public List<Follower> getAll() {
        return Follower.find.all();
    }
}