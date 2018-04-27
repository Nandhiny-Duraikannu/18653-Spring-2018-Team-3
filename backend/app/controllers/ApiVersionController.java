package controllers;

import DAO.*;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.api.libs.json.Json;
import play.api.libs.json.JsonNaming;
import play.data.*;
import play.mvc.*;
import scala.concurrent.java8.FuturesConvertersImpl;
import services.apiMemento.ApiMementoOriginator;
import services.apiMemento.ApiVersionCareTaker;
import services.factories.*;
import services.command.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ApiVersionController extends Controller {

    private final FormFactory formFactory;
    //private final ApiDAO apiDAO;
    private DAOInterface apiDAO;

    @Inject
    public ApiVersionController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.apiDAO = new RequestBroker().create("APIDAO");
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateApi() {
        DynamicForm form = formFactory.form().bindFromRequest();
        String type = form.get("type");

        if (type.equalsIgnoreCase("api")) {
            Form<Api> apiForm = formFactory.form(Api.class).bindFromRequest();
            Api api = apiForm.get();
            api.setUpdatedAt(new Date());
            ApiMementoOriginator originator = new ApiMementoOriginator();
            originator.setState(api);
            ApiVersionCareTaker careTaker = new ApiVersionCareTaker();
            careTaker.loadVersions(Integer.parseInt(api.getId().toString()));
            careTaker.add(originator.save(api));
            careTaker.saveVersions();
            return ok(api.toJson());
        } else {
            Form<Mashup> mashupForm = formFactory.form(Mashup.class).bindFromRequest();
            Mashup mashup = mashupForm.get();
            mashup.setUpdatedAt(new Date());
            ApiMementoOriginator originator = new ApiMementoOriginator();
            originator.setState(mashup);
            ApiVersionCareTaker careTaker = new ApiVersionCareTaker();
            careTaker.loadVersions(Integer.parseInt(mashup.getId().toString()));
            careTaker.add(originator.save(mashup));
            careTaker.saveVersions();
            return ok(mashup.toJson());
        }
    }

    public Result getVersionsForApi(int apiId) {
        List<Api> apis = apiDAO.getVersionsForApi(apiId);
        Iterator<Api> apiIterator = apis.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(apiIterator.hasNext()) {
            Api api = apiIterator.next();
            sb.append(api.toJson().toString());
            if (apiIterator.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return ok(sb.toString());
    }

}
