package cn.com.jy.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8081);

		WebAppContext context = new WebAppContext();
		context.setContextPath("/codegen");
//		context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		context.setResourceBase("src/main/webapp");
		context.setParentLoaderPriority(true);
		server.setHandler(context);

		server.start();
		server.join();
	}
}
