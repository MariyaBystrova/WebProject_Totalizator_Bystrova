package by.tr.totalizator.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tr.totalizator.connectionpool.ConnectionPool;
import by.tr.totalizator.connectionpool.exception.ConnectionPoolException;

public class ConnectionPoolListener implements ServletContextListener {
	private final static Logger rootLogger = LogManager.getRootLogger();
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	public ConnectionPoolListener() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		connectionPool.dispose();
		rootLogger.info("Listener was disposed.");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			connectionPool.initPoolData();
			rootLogger.info("Listener was initialized.");
		} catch (ConnectionPoolException e) {
			rootLogger.info("Problems with initializing listener: ", e);
		}
	}

}
