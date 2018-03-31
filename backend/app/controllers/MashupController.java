package controllers;

import forms.MashupForm;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import play.libs.Json;
import javax.inject.Inject;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;

import DAO.*;
import models.*;

public class MashupController extends Controller {
    private final FormFactory formFactory;

    private UserDAO userDAO = new UserDAO();
    private MashupDAO mashupDAO = new MashupDAO();

    @Inject
    public MashupController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    // Submit a Mashup
    public Result submitMashup() {
        Form<MashupForm> mashupForm = formFactory.form(MashupForm.class).bindFromRequest();
        MashupForm mashupInfo = mashupForm.get();

        User user = userDAO.findUserByUsername(mashupInfo.getUser());

        Mashup mashup = mashupDAO.createMashup(user, mashupInfo.getName(), mashupInfo.getUrl(), mashupInfo
                .getDescription());
        return ok(mashup.toJson());
    }

    public Result getAllMashups() {
        List<JsonNode> mashups = new ArrayList<>();
        for (Mashup mashup: mashupDAO.getAll()) {
            mashups.add(mashup.toJson());
        }
        return ok(Json.toJson(mashups));
    }

    // Search for Mashup
    public Result searchMashup() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String query = form.get("query");

        List<JsonNode> mashups = new ArrayList<>();
        for (Mashup mashup: mashupDAO.searchByName(query)) {
            mashups.add(mashup.toJson());
        }
        return ok(Json.toJson(mashups));
    }
}
