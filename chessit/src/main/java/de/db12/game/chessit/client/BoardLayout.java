package de.db12.game.chessit.client;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.AbsolutePositionDropController;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class BoardLayout extends Composite {
  interface MyUiBinder extends UiBinder<DockLayoutPanel, BoardLayout> {}
  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
  private static BoardResources res = GWT.create(BoardResources.class);

  @UiField Label label;
  @UiField AbsolutePanel board;

  public BoardLayout(int pxsize) {
    // createAndBindUi initializes this.nameSpan
	  initWidget(uiBinder.createAndBindUi(this));
	  initGame();
  }

  private void initGame() {
	PickupDragController dragController = new PickupDragController(board, false);
	GridConstrainedDropController dropController = new BoardDropController(board,100,100);
	dragController.registerDropController(dropController);
	
	Image bbauer = new Image();
	bbauer.setResource(res.bpawn());
	board.add(bbauer);
	dragController.makeDraggable(bbauer);
	
}

public void setName(String name) { label.setText(name); }
}