package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public BackendURLService () { }

    public String signupURL () { return baseURL + "signup"; }

    public String getAllMashupsURL() { return baseURL + "mashups"; }

    public String searchMashupsURL(String query) { return baseURL + "search/mashup?query="+query; }

    public String submitMashupURL() { return baseURL + "mashup"; }

}
