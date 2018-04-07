package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public BackendURLService () { }

    public String signupURL () { return baseURL + "signup"; }

    public String loginURL () { return baseURL + "login"; }

    public String resetPasswordURL() { return baseURL + "forgotpassword"; }

    public String newPasswordURL () { return baseURL + "confirmReset"; }

    //SUBMIT API
    public String submitApiURL () { return baseURL + "api"; }

     //Follow API
    public String followApiURL () { return baseURL + "follow"; }

    // Search API

    public String searchURL () { return baseURL + "search"; }

    public String searchAPIURL () { return baseURL + "search/api"; }


    public String getAllMashupsURL() { return baseURL + "mashups"; }

    public String searchMashupsURL(String query) { return baseURL + "searchApiMashup/mashup?query="+query; }

    public String submitMashupURL() { return baseURL + "api"; }

    public String getApiURL (int id) { return baseURL + "apis/" + id; }

    // UserForm profile
    public String userProfileURL (int userId) { return baseURL + "users/" + userId; }
}
