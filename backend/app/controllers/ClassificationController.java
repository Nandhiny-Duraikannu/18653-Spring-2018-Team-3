package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import services.apiFilter.ApiStateCriteria;
import services.apiFilter.ApprovedCriteria;
import services.apiFilter.PendingCriteria;
import services.apiStates.ApiState;
import services.apiStates.ApprovedApi;
import services.apiStates.PendingApi;
import services.factories.AbstractFactory;
import services.factories.ApiFactory;

import models.*;
import DAO.*;
import services.factories.FactoryProducer;
import services.submissions.SubmissionCache;


import javax.inject.Inject;
import java.util.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ClassificationController extends Controller {
    private final FormFactory formFactory;

    private TopicsDAO topicsDAO;

    @Inject
    public ClassificationController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.topicsDAO = new TopicsDAO();
    
    }

    public Result getTopics() {
        DynamicForm form = formFactory.form().bindFromRequest();
        int userId = Integer.parseInt(form.get("userId"));
        String topics = topicsDAO.getAllTopics(userId);
        return ok(topics);
    }

}
