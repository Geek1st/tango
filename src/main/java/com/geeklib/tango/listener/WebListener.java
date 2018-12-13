package com.geeklib.tango.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class WebListener
 *
 */
@javax.servlet.annotation.WebListener
public class WebListener implements ServletContextListener, ServletContextAttributeListener, ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public WebListener() {
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent event) {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent event) {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletContext application = sre.getServletContext();
		ServletRequest request = sre.getServletRequest();
		String domain = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + application.getContextPath();
		application.setAttribute("domain", domain);
	}

}
