package DAO;

import models.*;

import java.util.List;

public class MashupDAO {

    public List<Mashup> getAllMashups() {
        return Mashup.find.query().findList();
    }

    public List<Mashup> searchMashups (String searchParam, String type) {
        return Mashup.find.query().where().like("name", "%" + searchParam + "%").eq("apitype",type).findList();
    }
}
