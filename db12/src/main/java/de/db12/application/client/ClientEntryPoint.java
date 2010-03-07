package de.db12.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import de.db12.application.client.presenter.AppPresenter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClientEntryPoint implements EntryPoint {
	private final GreetingGinjector injector = GWT.create(GreetingGinjector.class);

	public void onModuleLoad() {
		final AppPresenter appPresenter = injector.getAppPresenter();
		appPresenter.go(RootPanel.get());

		injector.getPlaceManager().fireCurrentPlace();
	}
}
