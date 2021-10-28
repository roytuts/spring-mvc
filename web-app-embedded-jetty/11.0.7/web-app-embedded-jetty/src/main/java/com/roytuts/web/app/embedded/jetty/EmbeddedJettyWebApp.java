package com.roytuts.web.app.embedded.jetty;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedJettyWebApp {

	public static void main(String[] args) throws Exception {
		Server server = new Server(createThreadPool());

		NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
		connector.setPort(9090);
		connector.setHost("localhost");

		server.addConnector(connector);

		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setContextPath("/EmbeddedJettyWebApp");
		webAppContext.setResourceBase("src/main/webapp");
		webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		webAppContext.setParentLoaderPriority(true);

		server.setHandler(webAppContext);

		server.setStopAtShutdown(true);

		server.start();
		server.join();
	}

	private static ThreadPool createThreadPool() {
		QueuedThreadPool threadPool = new QueuedThreadPool(5);
		return threadPool;
	}
}
