package services.factories;

import models.*;

import java.util.List;

public abstract class AbstractFactory {
    public abstract Api getApi(String apiType, String name, String homepage, String endpoint, String version, String scope, String description, String email, List<Integer> apiIds);
    public abstract User getUser(String type);
}
