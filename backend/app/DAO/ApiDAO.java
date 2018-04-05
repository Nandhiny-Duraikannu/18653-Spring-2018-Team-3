package DAO;

import models.*;
import java.util.List;

import services.*;

public class ApiDAO {

    public List<Api> getAll() {
        return Api.find.query().fetch("user").findList();
    }

    public Api getById(int apiId) {
        return Api.find.query().where().eq("id", apiId).findUnique();
    }

//    public String getApi () {
//        Api apiDB = new Api();
//        List<Api> api_list = apiDB.find.all();
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("[");
//
//        String comma = "";
//        for (Api api : api_list) {
//            stringBuffer.append(comma);
//            comma = ", ";
//            stringBuffer.append(api.toJson());
//        }
//        stringBuffer.append("]");
//        return stringBuffer.toString();
//    }

    public List<Api> searchAPIs (String searchParam) {
        return Api.find.query().fetch("user").where().like("name", "%" + searchParam + "%").findList();
    }
}
