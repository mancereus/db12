package de.db12.game.chessit.client;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.DefaultEventBus;
import com.gwtplatform.mvp.client.DefaultProxyFailureHandler;
import com.gwtplatform.mvp.client.EventBus;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyFailureHandler;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class MyModule extends AbstractPresenterModule {

  @Override
  protected void configure() {  
    bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
    bind(PlaceManager.class).to(MyPlaceManager.class).in(Singleton.class);
    bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
    bind(RootPresenter.class).asEagerSingleton();
    bind(ProxyFailureHandler.class)
        .to(DefaultProxyFailureHandler.class).in(Singleton.class);
    
    // Presenters
    bindPresenter(BoardPresenter.class, 
        BoardPresenter.MyView.class, 
        BoardLayout.class, 
        BoardPresenter.MyProxy.class);
  }
}