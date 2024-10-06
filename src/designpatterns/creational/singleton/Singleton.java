package designpatterns.creational.singleton;

/**
 * <p>The Singleton design pattern ensures that a class has only one instance
 * and provides a global point of access to that instance.
 * <p>
 * This is particularly useful when exactly one object is needed to coordinate
 * actions across the system, such as when managing shared resources like
 * a connection pool, a configuration object, or logging.
 * <p>
 * This implementation is a lazy-loaded Singleton, meaning that the instance
 * is created only when it is first requested, which can help with
 * resource management.
 * <p>
 * Thread safety is not guaranteed in this implementation. If the
 * application is multithreaded, additional synchronization measures
 * (such as using synchronized blocks or other concurrency control)
 * should be implemented to ensure that the instance is created
 * safely in a concurrent environment. </p>
 *
 * Example usage:
 * <pre>
 * Singleton instance = Singleton.getInstance();
 * </pre>
 */
public class Singleton {
    private static Singleton SINGLETON_INSTANCE;

    /**
     * Private constructor to prevent instantiation from other classes.
     */
    private Singleton() {
    }

    /**
     * Returns the single instance of the Singleton class.
     * If the instance does not exist, it creates a new one.
     *
     * @return The singleton instance of the Singleton class.
     */
    public static Singleton getInstance() {
        if (SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new Singleton();
        }
        return SINGLETON_INSTANCE;
    }
}
