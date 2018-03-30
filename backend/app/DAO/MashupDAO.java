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

    public List<Mashup> searchByName(String query) {
        return Mashup.find.query().where().like("name", "%"+query+"%").findList();
    }
}
