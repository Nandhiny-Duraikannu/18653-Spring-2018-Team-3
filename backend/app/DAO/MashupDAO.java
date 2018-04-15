package DAO;

import models.Mashup;

import java.util.List;

public class MashupDAO {

    public List<Mashup> getAll() {
        return Mashup.find.query().findList();
    }

    public List<Mashup> searchMashups (String searchParam, String type) {
        return Mashup.find.query().where().like("name", "%" + searchParam + "%").eq("apitype",type).findList();
    }
}
