package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public BackendURLService () { }

    public String signupURL () { return baseURL + "signup"; }

    public String loginURL () { return baseURL + "login"; }

    public String resetURL () { return baseURL + "forgotpassword"; }

}
