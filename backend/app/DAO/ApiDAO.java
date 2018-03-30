package DAO;

import models.Api;
import services.ApiMashupFactory;

import java.util.List;

public class ApiDAO {
    private ApiMashupFactory apiFactory = new ApiMashupFactory();
    

    public Api addApi(String apiname, String apihomepage, String apiendpoint, String version, String scope, String apidescription, String emailaddress) {
        Api api = apiFactory.createObject("api");
        api.setParameters(apiname, apihomepage,apiendpoint,version,scope,apidescription,emailaddress);
        api.save();
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
}