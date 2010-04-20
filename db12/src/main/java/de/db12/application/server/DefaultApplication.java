package de.db12.application.server;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class DefaultApplication implements Application {

	@Override
	public void run() {
		
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ApplicationModule());
		Application application = injector
				.getInstance(DefaultApplication.class);
		application.run();
	}


}
