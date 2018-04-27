package services.factories;

import enums.UserType;
import models.*;

import java.util.List;

public abstract class AbstractFactory {
    public abstract Api getApi(String apiType, String name, String homepage, String endpoint, String version, String scope, String description, String email, List<Integer> apiIds);
    public abstract User getUser(UserType type);
}
