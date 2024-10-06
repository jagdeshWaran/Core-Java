package designpatterns.creational.singleton.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * AbstractLogger serves as a base class for logging messages with different log levels.
 * It provides utility methods to format log messages with timestamps and log levels.
 * Subclasses should implement specific logging mechanisms (e.g., console logging, file logging).
 */
public abstract class AbstractLogger {

    /**
     * Enum representing the various log levels.
     */
    protected enum LogLevel {
        INFO,  // Informational messages
        WARN,  // Warning messages indicating potential issues
        ERROR  // Error messages indicating failure or critical issues
    }

    /**
     * Retrieves the current timestamp formatted as "yyyy-MM-dd HH:mm:ss".
     *
     * @return A string representation of the current timestamp.
     */
    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Generates a formatted log message with the current timestamp and specified log level.
     *
     * @param message The message to be logged.
     * @param level The log level associated with the message.
     * @return A formatted log message string.
     */
    protected String getLogMessage(String message, LogLevel level) {
        return String.format("%s [%s]: %s", getCurrentTimestamp(), level, message);
    }

    /**
     * Logs an informational message.
     *
     * @param message The informational message to log.
     * @return A formatted log message at the INFO level.
     */
    public String infoMsg(String message) {
        return getLogMessage(message, LogLevel.INFO);
    }

    /**
     * Logs a warning message.
     *
     * @param message The warning message to log.
     * @return A formatted log message at the WARN level.
     */
    public String warnMsg(String message) {
        return getLogMessage(message, LogLevel.WARN);
    }

    /**
     * Logs an error message.
     *
     * @param message The error message to log.
     * @return A formatted log message at the ERROR level.
     */
    public String errorMsg(String message) {
        return getLogMessage(message, LogLevel.ERROR);
    }
}
