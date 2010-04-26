package de.db12.game.chessit.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class AppController {

	private HandlerManager eventbus;

	public AppController(HandlerManager eventBus) {
		this.eventbus = eventBus;
	}

	public void go(RootLayoutPanel container) {
		new BoardPresenter().go(container);
		
	}

}
