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

    public List<Api> searchAPIs (String searchParam,String type) {
        return Api.find.query().where().like("name", "%" + searchParam + "%").eq("apitype",type).findList();
    }

    public Api getApiById(int id) {
        return Api.find.query().fetch("user").where().eq("id", id).findUnique();
        //.fetch("user")
    }

    public String getCommentsForApi (int id) {
        List <ApiComments> comments = ApiComments.find.query().where().eq("apiid", id).findList();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < comments.size(); i++) {
            sb.append(comments.get(i).toJson());
            if (i != (comments.size() - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");

        System.out.println(sb.toString());

        return sb.toString();
    }
}
