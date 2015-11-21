package fr.tungnguyen.log4j2;

import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.apache.logging.log4j.web.Log4jWebSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by tungnguyen on 20/11/2015.
 */
@WebListener
public class Log4j2Listener implements ServletContextListener {
    Log4jServletContextListener listener = new Log4jServletContextListener();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setInitParameter(Log4jWebSupport.LOG4J_CONFIG_LOCATION, "file:/Volumes/Workspace/config/log4j2.xml");
        listener.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        listener.contextDestroyed(event);
    }
}
