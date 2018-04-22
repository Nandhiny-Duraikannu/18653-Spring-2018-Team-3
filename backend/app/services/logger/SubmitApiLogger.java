package services.logger;

import enums.LoggerType;

public class SubmitApiLogger extends AbstractLogger {

    public SubmitApiLogger() {
        this.loggerType = LoggerType.SUBMIT_API_LOGGER;
        this.nextLogger = new SearchApiLogger();
    }

    @Override
    protected String getMessage(String username, String apiName) {
        return username + " submitted API: " + apiName;
    }
}
