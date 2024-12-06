package org.example;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try{
            FileHandler fileHandler = new FileHandler("system.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e){
            logger.log(Level.SEVERE, "Failed to initialize logger", e.getMessage());
        }
    }

    public static void logInfo(String message){
        logger.info(message);
        System.out.println("[INFO]: " + message);
    }

    public static void logError(String message, Throwable throwable){
        logger.log(Level.SEVERE, message, throwable);
        System.out.println("[ERROR]: " + message);
    }
}
