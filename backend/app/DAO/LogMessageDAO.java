package DAO;

import enums.LoggerType;
import models.LogMessage;
import services.logger.*;

import java.util.List;

public class LogMessageDAO {

    AbstractLogger loggerChain = LoggerChain.getLoggerChain();

    public List<LogMessage> getAllLogMessages() {
        return LogMessage.find.all();
    }

    private LogMessage writeLogMessage(LoggerType loggerType, String username, String apiName) {
        String message = loggerChain.logMessage(loggerType, username, apiName);
        LogMessage logMessage = new LogMessage(message);
        logMessage.save();
        return logMessage;
    }

    public void writeSubmitApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.SUBMIT_API_LOGGER, username, apiName);
    }

    public void writeSearchApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.SEARCH_API_LOGGER, username, apiName);
    }

    public void writeUpdateApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.UPDATE_API_LOGGER, username, apiName);
    }

    public void writeViewApiLogMessage(String username, String apiName) {
        writeLogMessage(LoggerType.VIEW_API_LOGGER, username, apiName);
    }
}
