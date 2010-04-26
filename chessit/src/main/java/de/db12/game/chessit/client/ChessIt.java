package de.db12.game.chessit.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class ChessIt implements EntryPoint {
	public void onModuleLoad() {
		Log.setUncaughtExceptionHandler();

		DeferredCommand.addCommand(new Command() {
			public void execute() {
				onModuleLoad2();
			}
		});
	}

	private void onModuleLoad2() {
		BoardLayout p = new BoardLayout(100);
//		p.setName("test");
		HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(eventBus);
	    appViewer.go(RootLayoutPanel.get());
//		DockLayoutPanel p = new DockLayoutPanel(Unit.EM);
//		Label header = new Label("ChessIt");
//		header.setStyleName("");
//		p.addNorth(header, 4);
//		p.addSouth(new HTML("footer"), 2);
//		p.addWest(new HTML("navigation"), 10);
//		p.add(new HTML("content"));
		Log.info("started");
	}
}
