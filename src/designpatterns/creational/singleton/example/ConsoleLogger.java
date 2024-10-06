package designpatterns.creational.singleton.example;

/**
 * <P>The ConsoleLogger class is a singleton implementation of the Logger interface,
 * which is responsible for logging messages to the console. This class extends
 * AbstractLogger and overrides the info, warn, and error methods to provide
 * specific logging behavior.</P>
 *
 * <P>This class ensures that only one instance of ConsoleLogger is created
 * throughout the application, following the Singleton design pattern. It
 * provides thread-safe access to the single instance.</P>
 *
 * Example usage:
 * <pre>
 * Logger logger = ConsoleLogger.getConsoleLogger();
 * logger.info("This is an info message");
 * logger.warn("This is a warning message");
 * logger.error("This is an error message");
 * </pre>
 *
 * @see Logger
 * @see AbstractLogger
 * @see FileLogger
 */
public class ConsoleLogger extends AbstractLogger implements Logger {

    private static Logger consoleLogger;

    // Private constructor to prevent instantiation from other classes
    private ConsoleLogger() {
    }

    /**
     * Logs an informational message to the console.
     *
     * @param message the message to log
     */
    @Override
    public void info(String message) {
        System.out.println(infoMsg(message));
    }

    /**
     * Logs a warning message to the console.
     *
     * @param message the message to log
     */
    @Override
    public void warn(String message) {
        System.out.println(warnMsg(message));
    }

    /**
     * Logs an error message to the console.
     *
     * @param message the message to log
     */
    @Override
    public void error(String message) {
        System.out.println(errorMsg(message));
    }

    /**
     * Provides a global point of access to the ConsoleLogger instance.
     * This method uses double-checked locking to ensure thread-safe
     * instantiation of the singleton instance.
     *
     * @return the single instance of ConsoleLogger
     */
    public static Logger getConsoleLogger() {
        if (consoleLogger == null) {
            synchronized (ConsoleLogger.class) {
                if (consoleLogger == null) {
                    consoleLogger = new ConsoleLogger();
                }
            }
        }
        return consoleLogger;
    }
}
