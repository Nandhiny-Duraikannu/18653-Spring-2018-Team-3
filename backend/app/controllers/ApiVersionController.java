package controllers;

import DAO.*;
import models.*;
import play.data.*;
import play.mvc.*;
import services.apiMemento.ApiMementoOriginator;
import services.apiMemento.ApiVersionCareTaker;
import services.factories.*;

import javax.inject.Inject;

public class ApiVersionController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public ApiVersionController(FormFactory formFactory) {
        this.formFactory = formFactory;
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

}
