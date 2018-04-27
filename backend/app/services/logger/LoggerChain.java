package services.logger;

public class LoggerChain {
    public static AbstractLogger getLoggerChain() {
        return new SubmitApiLogger();
    }
}
