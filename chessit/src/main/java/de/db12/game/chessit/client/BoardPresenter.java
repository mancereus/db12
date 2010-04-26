package de.db12.game.chessit.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.db12.game.chessit.client.model.BoardModel;

public class BoardPresenter implements Presenter {
	  public interface Display extends HasValue<List<String>> {
	    HasClickHandlers getAddButton();
	    HasClickHandlers getDeleteButton();
	    HasClickHandlers getList();
	    void setData(List<String> data);
	    int getClickedRow(ClickEvent event);
	    List<Integer> getSelectedRows();
	    Widget asWidget();
	  }
	BoardModel model;
	BoardLayout view;
	
	public BoardPresenter() {
		model = new BoardModel(30);
	}

	@Override
	public void go(HasWidgets container) {
		container.add(new BoardLayout(60));
		
	}
}
