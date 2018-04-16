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

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApiVersionController extends Controller {

    private final FormFactory formFactory;
    private final ApiDAO apiDAO;

    @Inject
    public ApiVersionController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.apiDAO = new ApiDAO();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateApi() {
        Form<Api> apiForm = formFactory.form(Api.class).bindFromRequest();
        Api api = apiForm.get();

        ApiMementoOriginator originator = new ApiMementoOriginator();
        originator.setState(api);
        ApiVersionCareTaker careTaker = new ApiVersionCareTaker();
        careTaker.loadVersions(Integer.parseInt(api.getId().toString()));
        careTaker.add(originator.save(api));
        careTaker.saveVersions();
        return ok(api.toJson());
    }

    public Result getVersionsForApi(int apiId) {
        List<Api> apis = apiDAO.getVersionsForApi(apiId);
        List<String> jsonApis = new ArrayList<>();
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
