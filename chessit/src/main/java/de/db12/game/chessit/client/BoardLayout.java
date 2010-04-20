package de.db12.game.chessit.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;

public class BoardLayout extends Composite {
  interface MyUiBinder extends UiBinder<DockLayoutPanel, BoardLayout> {}
  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

  @UiField Label label;

  public BoardLayout() {
    // createAndBindUi initializes this.nameSpan
	  initWidget(uiBinder.createAndBindUi(this));
  }

  public void setName(String name) { label.setText(name); }
}