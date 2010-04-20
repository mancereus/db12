package de.db12.game.chessit.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;

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
		BoardLayout p = new BoardLayout();
		p.setName("test");
		RootLayoutPanel.get().add(p);
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
