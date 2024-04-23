package org.example.util;

import org.apache.log4j.Logger;
import org.example.listeners.LogListener;

public class LoggerUtil {


    /** The logger. */
    private static Logger logger = Logger.getLogger(LogListener.class);

    /**
     * Log.
     *
     * @param message the message
     */
    public static void log(String message) {
        logger.info(message);
    }

    /**
     * Gets the logger.
     */
    public static Logger getLogger() {
        return logger;
    }
}
