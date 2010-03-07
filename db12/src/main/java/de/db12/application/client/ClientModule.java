package de.db12.application.client;

import javax.persistence.EntityManager;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import com.google.inject.Singleton;

import de.db12.application.client.dispatch.base.CachingDispatchAsync;
import de.db12.application.client.presenter.AppPresenter;

public class ClientModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bind(EntityManager.class).to(EntityManagerImpl.class);
		
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(PlaceManager.class).in(Singleton.class);
		
//		bindPresenter(GreetingPresenter.class, GreetingPresenter.Display.class, GreetingView.class);
//		bindPresenter(GreetingResponsePresenter.class, GreetingResponsePresenter.Display.class, GreetingResponseView.class);
//		
		bind(AppPresenter.class).in(Singleton.class);
		bind(CachingDispatchAsync.class);
	}
}