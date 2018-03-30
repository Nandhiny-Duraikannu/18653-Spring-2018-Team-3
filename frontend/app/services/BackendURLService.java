package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public BackendURLService () { }

    public String signupURL () { return baseURL + "signup"; }

    public String loginURL () { return baseURL + "login"; }

    public String resetPasswordURL() { return baseURL + "forgotpassword"; }

    public String newPasswordURL () { return baseURL + "confirmReset"; }

    //SUBMIT API
    public String submitApiURL () { return baseURL + "submitapi"; }

    // Search API
    public String searchAPIURL () { return baseURL + "searchAPI"; }

    public String getAllMashupsURL() { return baseURL + "mashups"; }

    public String searchMashupsURL(String query) { return baseURL + "search/mashup?query="+query; }

    public String submitMashupURL() { return baseURL + "mashup"; }
}
