package com.roytuts.web.app.embedded.jetty;

import javax.servlet.ServletContext;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class EmbeddedJettyWebApp {

	public static void main(String[] args) {
		// load the Jetty configuration XML file
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("embedded-jetty-web-app.xml");

		// register to cleanup everything before shutting down server
		ctx.registerShutdownHook();

		// get the server bean instance defined in XML file
		Server server = (Server) ctx.getBean("jettyServer");

		// get the servlet context
		ServletContext servletContext = null;
		for (Handler handler : server.getHandlers()) {
			if (handler instanceof Context) {
				Context context = (Context) handler;
				servletContext = context.getServletContext();
			}
		}

		// set the context attributes for web application
		XmlWebApplicationContext wctx = new XmlWebApplicationContext();
		wctx.setParent(ctx);
		wctx.setConfigLocation("");
		wctx.setServletContext(servletContext);
		wctx.refresh();
		
		servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, wctx);
	}

}
