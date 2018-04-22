package services.logger;

import enums.LoggerType;

public class SearchApiLogger extends AbstractLogger {

    public SearchApiLogger() {
        this.loggerType = LoggerType.SEARCH_API_LOGGER;
        this.nextLogger = new UpdateApiLogger();
    }

    @Override
    protected String getMessage(String username, String apiName) {
        return username + " searched for API: " + apiName;
    }
}
