package de.db12.game.chessit.client;

import java.util.List;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Panel;

import de.db12.game.chessit.client.model.BoardModel;
import de.db12.game.chessit.client.model.Place;
import de.db12.game.chessit.client.model.Stone;

public class BoardPresenter implements Presenter {
    public interface Display extends HasValue<List<String>> {
        HasWidgets getWhiteHand();

        HasWidgets getBlackHand();

        HasWidgets getWhiteDrop();

        HasWidgets getBlackDrop();

        HasWidgets getHelp();

        Panel getBoard();
    }

    BoardModel model;
    BoardLayout view;

    public BoardPresenter() {
        model = new BoardModel(30);
        view = new BoardLayout(120);
        refreshView();
    }

    private void refreshView() {
        view.showBoard(model.getBoard());

    }

    @Override
    public void go(HasWidgets container) {
        container.add(view);

    }

    public void moveStone(Stone stone, Place place) {
        model.moveStone(stone, place);
    }

}
