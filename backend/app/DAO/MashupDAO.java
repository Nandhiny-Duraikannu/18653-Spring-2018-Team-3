package DAO;

import models.*;
import java.util.List;

public class MashupDAO {

    public Mashup createMashup(User user, String name, String url, String description) {
        if (user == null) return null;

        Mashup mashup = new Mashup();
        mashup.setParameters(name, url, description);

        user.mashups.add(mashup);
        user.save();
        return mashup;
    }

    public List<Mashup> getAll() {
        return Mashup.find.query().fetch("user").findList();
    }

    public List<Mashup> searchByName(String query) {
        return Mashup.find.query().fetch("user").where().like("name", "%"+query+"%").findList();
    }
}
