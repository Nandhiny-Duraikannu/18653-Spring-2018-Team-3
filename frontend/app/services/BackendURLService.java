package services;

public class BackendURLService {

    public final String baseURL = "http://localhost:9000/";

    public final String url_accesstoken = "https://api.sandbox.paypal.com/v1/oauth2/token";


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



    public String donateURL () { return baseURL + "donate";}

    public String paypalAccessToken() {return url_accesstoken; }


    public String getMessagesForUserURL (int userId) { return baseURL + "messages/" + userId; }

    public String sendMessageURL () { return baseURL + "messages"; }

    public String getAllUsersURL () { return baseURL + "users"; }

    // Update API
    public String updateApiUrl () { return baseURL + "apis/version"; }

    public String getVersionsForApiURL(int apiId) { return baseURL + "apis/" + apiId + "/versions"; }
    public String getApiPerState () { return baseURL + "apis/state"; }

    public String approveApiURL () { return baseURL + "api/state"; }
  
    public String getLogMessagesURL () { return baseURL + "log"; }
  
    //Topics
    public String getTopicsURL (int userId) { return baseURL + "topics?userId="+userId; }
}
