package services.logger;

import enums.LoggerType;

public abstract class AbstractLogger {
    protected LoggerType loggerType;

    protected AbstractLogger nextLogger;

    public String logMessage(LoggerType loggerType, String username, String apiName) {
        if (this.loggerType == loggerType) {
            return getMessage(username, apiName);
        }
        if (nextLogger != null) {
            return nextLogger.logMessage(loggerType, username, apiName);
        }
        return "";
    }

    abstract protected String getMessage(String username, String apiName);
}
