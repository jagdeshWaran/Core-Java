package designpatterns.creational.singleton.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The FileLogger class is a singleton implementation of the Logger interface,
 * responsible for logging messages to a file named "application.log".
 * It extends the AbstractLogger class to provide specific implementations for
 * logging informational, warning, and error messages.
 *
 * This logger is designed to be thread-safe and can be accessed globally
 * via the static method {@link #getFileLogger()}.
 *
 * @see Logger
 * @see AbstractLogger
 * @see ConsoleLogger
 */
public class FileLogger extends AbstractLogger implements Logger {
    private static Logger fileLogger; // Singleton instance of FileLogger
    private PrintWriter writer; // Writer to log messages to the file

    /**
     * Private constructor to initialize the PrintWriter for logging.
     * This constructor attempts to open the "application.log" file in append mode.
     *
     * If an error occurs while initializing the logger, it prints an error message
     * to the standard error output.
     */
    private FileLogger() {
        try {
            // Initialize the PrintWriter to log to a file
            writer = new PrintWriter(new FileWriter("application.log", true), true);
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    @Override
    public void info(String message) {
        writer.println(infoMsg(message));
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    @Override
    public void warn(String message) {
        writer.println(warnMsg(message));
    }

    /**
     * Logs an error message.
     *
     * @param message The message to log.
     */
    @Override
    public void error(String message) {
        writer.println(errorMsg(message));
    }

    /**
     * Retrieves the singleton instance of FileLogger.
     * This method is thread-safe and ensures that only one instance
     * of FileLogger is created during the application's lifecycle.
     *
     * @return The singleton instance of FileLogger.
     */
    public static Logger getFileLogger() {
        if (fileLogger == null) {
            synchronized (ConsoleLogger.class) {
                if (fileLogger == null) {
                    fileLogger = new FileLogger();
                }
            }
        }
        return fileLogger;
    }

    /**
     * Closes the PrintWriter, releasing any system resources associated with it.
     * It is important to call this method to ensure that all log messages are
     * flushed and the file is properly closed.
     */
    public void close() {
        writer.close();
    }
}
