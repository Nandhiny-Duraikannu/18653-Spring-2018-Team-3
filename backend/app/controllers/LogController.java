package controllers;

import DAO.*;
import models.LogMessage;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.command.*;

import java.util.List;

public class LogController extends Controller {
    private LogMessageDAO logMessageDAO = new LogMessageDAO();

    public Result getLogMessages() {
        List<LogMessage> logMessages = logMessageDAO.getAllLogMessages();
        return ok(Json.toJson(logMessages));
    }
}
