package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public BackendURLService () { }

    public String signupURL () { return baseURL + "signup"; }

    //SUBMIT API
    public String submitApiURL () { return baseURL + "submitapi"; }


}
