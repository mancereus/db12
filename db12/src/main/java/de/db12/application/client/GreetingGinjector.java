package de.db12.application.client;

import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import de.db12.application.client.presenter.AppPresenter;
import de.db12.application.server.ApplicationModule;

@GinModules({ClientModule.class})
public interface GreetingGinjector extends Ginjector {

	AppPresenter getAppPresenter();

	PlaceManager getPlaceManager();

}