package services.logger;

import enums.LoggerType;

public class ViewApiLogger extends AbstractLogger {

    public ViewApiLogger() {
        this.loggerType = LoggerType.VIEW_API_LOGGER;
        this.nextLogger = null;
    }

    @Override
    protected String getMessage(String username, String apiName) {
        return username + " viewed API: " + apiName;
    }
}
