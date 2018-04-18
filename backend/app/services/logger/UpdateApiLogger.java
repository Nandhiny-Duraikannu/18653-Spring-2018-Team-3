package services.logger;

import enums.LoggerType;

public class UpdateApiLogger extends AbstractLogger {

    public UpdateApiLogger() {
        this.loggerType = LoggerType.UPDATE_API_LOGGER;
        this.nextLogger = new ViewApiLogger();
    }

    @Override
    protected String getMessage(String username, String apiName) {
        return username + " updated API: " + apiName;
    }
}
