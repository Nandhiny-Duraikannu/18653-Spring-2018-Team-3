package controllers;

import DAO.*;
import models.*;
import play.data.*;
import play.libs.Json;
import play.mvc.*;
import services.apiMemento.ApiMemento;
import services.apiMemento.ApiMementoOriginator;
import services.apiMemento.ApiVersionCareTaker;
import services.factories.*;

import javax.inject.Inject;

public class ApiVersionController extends Controller {

    private final FormFactory formFactory;

    private MashupDAO mashupDAO;
    private ApiDAO apiDAO;
    private UserDAO userDAO;

    private AbstractFactory apiFactory;

    @Inject
    public ApiVersionController(FormFactory formFactory) {
        this.formFactory = formFactory;

        this.mashupDAO = new MashupDAO();
        this.apiDAO = new ApiDAO();
        this.userDAO = new UserDAO();

        this.apiFactory = FactoryProducer.getFactory("api");
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

        System.out.println("==========================");
        System.out.println("api " + api);
        System.out.println("==========================");
        return ok(Json.toJson(api));
    }

}
