package designpatterns.creational.singleton.example;

/**
 * The Logger interface defines a contract for logging messages at different
 * levels of severity. Implementing classes must provide specific implementations
 * for logging informational, warning, and error messages.
 *
 * This interface serves as a blueprint for various logging mechanisms, allowing
 * for flexibility and scalability in logging implementations, such as console
 * logging, file logging, or logging to external systems.
 */
public interface Logger {

    /**
     * Logs an informational message.
     *
     * @param message The message to log. This should contain information that is
     *                useful for understanding the application's flow and state.
     */
    void info(String message);

    /**
     * Logs a warning message.
     *
     * @param message The message to log. This should indicate a potential issue
     *                that may require attention but does not stop the execution
     *                of the program.
     */
    void warn(String message);

    /**
     * Logs an error message.
     *
     * @param message The message to log. This should contain details about an
     *                error that has occurred, which may require immediate
     *                attention or intervention.
     */
    void error(String message);
}
