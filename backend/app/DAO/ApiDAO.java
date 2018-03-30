package DAO;

import io.ebean.ExpressionList;
import models.*;
import java.util.List;

import play.api.libs.json.Json;
import services.*;

public class ApiDAO {
    private ApiMashupFactory apiFactory = new ApiMashupFactory();
    

    public Api addApi(User user, String apiname, String apihomepage, String apiendpoint, String version, String scope, String apidescription, String emailaddress) {
        Api api = apiFactory.createObject("api");
        api.setParameters(apiname, apihomepage,apiendpoint,version,scope,apidescription,emailaddress);
        
        user.apis.add(api);
        user.save();
        // api.save();
        return api;
    }

    public String getApi () {
        Api apiDB = new Api();
        List<Api> api_list = apiDB.find.all();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        String comma = "";
        for (Api api : api_list) {
            stringBuffer.append(comma);
            comma = ", ";
            stringBuffer.append(api.toJSON());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public List<Api> searchAPIs (String searchParam) {
        return Api.find.query().fetch("user").where().like("apiname", "%" + searchParam + "%").findList();
    }
}
