package designpatterns.creational.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A custom logger that follows the Singleton design pattern.
 * This logger ensures that there is only one instance used throughout the application,
 * and it provides methods to log messages with different severity levels (INFO, WARNING, ERROR).
 */
public class Logger {
    private static Logger loggerInstance;
    private PrintWriter writer;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        try {
            // Initialize the PrintWriter to log to a file
            writer = new PrintWriter(new FileWriter("application.log", true), true);
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    /**
     * Returns the single instance of the Logger class.
     * If the instance does not exist, it creates a new one.
     *
     * @return The singleton instance of the Logger class.
     */
    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    public void info(String message) {
        log("INFO", message);
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    public void warning(String message) {
        log("WARNING", message);
    }

    /**
     * Logs an error message.
     *
     * @param message The message to log.
     */
    public void error(String message) {
        log("ERROR", message);
    }

    /**
     * Writes the log message to the log file with a timestamp.
     *
     * @param level The severity level of the log message.
     * @param message The message to log.
     */
    private void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String finalMessage = String.format("%s [%s]: %s", timestamp, level, message);
        writer.println(finalMessage);
        System.out.println(finalMessage);
    }

    /**
     * Closes the PrintWriter when the logger is no longer needed.
     */
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
