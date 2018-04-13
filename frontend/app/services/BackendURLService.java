package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public final String paypal = "https://api.sandbox.paypal.com/v1/payments/payment";

    public final String accessToken = "https://api.sandbox.paypal.com/v1/oauth2/token";

    public BackendURLService () { }

    public String signupURL () { return baseURL + "signup"; }

    public String loginURL () { return baseURL + "login"; }

    public String resetPasswordURL() { return baseURL + "forgotpassword"; }

    public String newPasswordURL () { return baseURL + "confirmReset"; }

    //SUBMIT API
    public String submitApiURL () { return baseURL + "api"; }

     //Follow API
    public String followApiURL () { return baseURL + "follow"; }

     //Followers
    public String getFollowersURL (String userId) { return baseURL + "followers?userId="+userId; }

    // Search API

    public String searchURL () { return baseURL + "search"; }

    public String searchAPIURL () { return baseURL + "search/api"; }


    public String getAllMashupsURL() { return baseURL + "mashups"; }

    public String searchMashupsURL(String query) { return baseURL + "searchApiMashup/mashup?query="+query; }

    public String submitMashupURL() { return baseURL + "api"; }

    public String getAllApisURL () { return baseURL + "apis"; }

    public String getApiURL (int id) { return baseURL + "apis/" + id; }

    public String getFollowers (int id) { return baseURL + "followers?userId=" + id; }
    // UserForm profile
    public String userProfileURL (int userId) { return baseURL + "users/" + userId; }


    public String donateURL (String payId) { return baseURL + "donate?payId="+payId; }

    public String paypalPayment() {
        return paypal;
    }

    public String paypalAccessToken() {
        return accessToken;
    }


}
