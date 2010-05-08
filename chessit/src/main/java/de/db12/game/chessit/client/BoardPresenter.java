package de.db12.game.chessit.client;

import java.util.List;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;

import de.db12.game.chessit.client.event.MoveStoneEvent;
import de.db12.game.chessit.client.event.MoveStoneEventHandler;
import de.db12.game.chessit.client.model.BoardModel;
import de.db12.game.chessit.client.model.Field;
import de.db12.game.chessit.client.model.Place;
import de.db12.game.chessit.client.model.Stone;

public class BoardPresenter implements Presenter, MoveStoneEventHandler {
    public interface Display extends HasValue<List<String>> {
        HasWidgets getWhiteHand();

        HasWidgets getBlackHand();

        HasWidgets getWhiteDrop();

        HasWidgets getBlackDrop();

        HasWidgets getHelp();

        AbsolutePanel getBoard();

        AbsolutePanel getTable();
    }

    BoardModel model;
    BoardLayout view;
    private final HandlerManager eventbus;
    PickupDragController dragController = null;

    public BoardPresenter(HandlerManager eventbus) {
        this.eventbus = eventbus;
        model = new BoardModel(30);
        view = new BoardLayout(120, eventbus);
        dragController = new PickupDragController(view.getBoard(), false);
        refreshView();
        eventbus.addHandler(MoveStoneEvent.getType(), this);

    }

    private void refreshView() {
        clearBoard();
        showBoard();

    }

    private void showBoard() {
        // int height = boardview.getOffsetHeight();
        // int width = boardview.getOffsetWidth();
        // int pxsize = Math.max(Math.min(height, width) / 8, 30);
        int pxsize = 120;

        for (Field field : model.getBoard().getFields()) {
            StoneView stone = new StoneView(field, pxsize);
            view.getBoard().add(stone, 20 + pxsize * (field.getX() - model.getBoard().getXOffset()),
                    pxsize * (field.getY() - model.getBoard().getYOffset()));
            dragController.registerDropController(new FieldDropController(eventbus, stone));
            dragController.makeDraggable(stone);
        }

    }

    private void clearBoard() {
        dragController.unregisterDropControllers();
        view.getBoard().clear();
    }

    @Override
    public void go(HasWidgets container) {
        container.add(view);

    }

    public void moveStone(Place origin, Stone stone, Place place) {
        model.moveStone(origin, stone, place);
    }

    @Override
    public void onStoneMoved(MoveStoneEvent event) {
        moveStone(event.getOrigin(), event.getStone(), event.getTarget());
        refreshView();
    }
}
