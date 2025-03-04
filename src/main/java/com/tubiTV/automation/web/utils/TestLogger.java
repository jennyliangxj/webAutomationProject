package com.tubiTV.automation.web.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/2/24  13:56
 */
public class TestLogger {
    private  static final ThreadLocal<Logger> logger = new ThreadLocal<>();

    public static void init(Class<?> clazz){
        logger.set(LogManager.getLogger(clazz));
    }

    public static void info(String message){
        logger.get().info(message);
    }

    public static void debug(String message){
        logger.get().debug(message);
    }

    public static void error(String message, String throwable){
        logger.get().error(message,throwable);
    }

    public static void warn(String message) {
        logger.get().warn(message);
    }
}
