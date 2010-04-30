package de.db12.game.chessit.client;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class BoardDropController extends GridConstrainedDropController {
	private static BoardResources res = BoardResources.INSTANCE;
	public BoardDropController(AbsolutePanel dropTarget, int gridX, int gridY) {
		super(dropTarget, gridX, gridY);
		
	}
	@Override
	public void onEnter(DragContext context) {
		super.onEnter(context);
		context.draggable.addStyleName(res.style().enterBG());		
	}

}
