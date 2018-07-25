package bbs.helper.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class MyLogger {
	
	private static final Map<Class<?>, Logger> loggerMap = new HashMap<>();
	
	private static final Logger defaultLogger = Logger.getLogger(MyLogger.class);

	public static Logger getLogger(Class<?> logClass) {
		if(!loggerMap.containsKey(logClass)) {
			Logger newLogger = Logger.getLogger(logClass);
			loggerMap.put(logClass, newLogger);
			return newLogger;
		}
		else {
			return loggerMap.get(logClass);
		}
	}
	
	public static void info(String info) {
		defaultLogger.info(info);
	}
	
	public static <T> void info(T info) {
		info(String.valueOf(info));
	}
	
	public static void info(Class<?> logClass, String info) {
		getLogger(logClass).info(info);
	}

	public static void infoln(String string) {
		// TODO Auto-generated method stub
		info("\n" + string);
	}
}
