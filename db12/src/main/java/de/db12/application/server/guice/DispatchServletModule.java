package de.db12.application.server.guice;

import com.google.inject.servlet.ServletModule;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		// NOTE: the servlet context will probably need changing
		//serve("/test/dispatch").with(DispatchServiceServlet.class);
	}

}