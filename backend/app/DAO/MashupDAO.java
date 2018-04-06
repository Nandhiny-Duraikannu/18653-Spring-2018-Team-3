package DAO;

import models.Mashup;

import java.util.List;
import services.*;

public class MashupDAO {

    public List<Mashup> getAll() {
        return Mashup.find.query().findList();
    }

//  //  public Api getById(int apiId) {
//        return Api.find.query().where().eq("id", apiId).findUnique();
//    }

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

    public List<Mashup> searchMashups (String searchParam, String type) {
        return Mashup.find.query().where().like("name", "%" + searchParam + "%").eq("apitype",type).findList();
    }
}
