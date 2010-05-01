package de.db12.game.chessit.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
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
        HandlerManager eventBus = new HandlerManager(null);
        AppController appViewer = new AppController(eventBus);
        appViewer.go(RootLayoutPanel.get());
        Log.info("started");
    }
}
