package com.app.aarcs.util;


import com.app.aarcs.exception.ServiceExceptionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtil {

	private LoggingUtil() {}

	public static void printInfo(Class<?> clazz, Object object) {
		Logger logger = LogManager.getLogger(clazz);
		logger.info(object);
	}

	public static void printError( Object object) {
		Logger logger = LogManager.getLogger(ServiceExceptionHandler.class);
		logger.error(object);
	}
}
