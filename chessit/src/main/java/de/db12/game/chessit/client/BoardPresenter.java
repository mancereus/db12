package de.db12.game.chessit.client;

import java.util.List;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

import de.db12.game.chessit.client.event.MoveStoneEvent;
import de.db12.game.chessit.client.event.MoveStoneEventHandler;
import de.db12.game.chessit.client.model.BoardModel;
import de.db12.game.chessit.client.model.Field;
import de.db12.game.chessit.client.model.InPlace;
import de.db12.game.chessit.client.model.Place;
import de.db12.game.chessit.client.model.Stone;
import de.db12.game.chessit.client.model.Stone.Type;

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

        view.getWhiteHand().clear();
        for (int i = 0; i < Math.min(model.getWHand().size(), 3); i++) {
            StoneView stoneview = new StoneView(new InPlace(i, model.getWHand().get(i)), 50);
            model.getWHand().remove(i);
            view.getWhiteHand().add(stoneview);
            dragController.makeDraggable(stoneview);
        }
        view.getBlackHand().clear();
        for (int i = 0; i < Math.min(model.getBHand().size(), 3); i++) {
            StoneView stoneview = new StoneView(new InPlace(i, model.getBHand().get(i)), 50);
            model.getBHand().remove(i);
            view.getBlackHand().add(stoneview);
            dragController.makeDraggable(stoneview);
        }
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
        BoardSize bsize = new BoardSize();
        for (Field field : model.getBoard().getFields()) {
            int xpos = field.getX() - model.getBoard().getXOffset();
			int ypos = field.getY() - model.getBoard().getYOffset();
			bsize.updateX(xpos);
			bsize.updateY(ypos);
        }
        pxsize = 700/bsize.getMaxSize();
        view.getHelp().add(new Label("" + bsize.getMaxSize()));
        for (Field field : model.getBoard().getFields()) {
            StoneView stone = new StoneView(field, pxsize);
            int xpos = field.getX() - model.getBoard().getXOffset();
			int ypos = field.getY() - model.getBoard().getYOffset();
			view.getBoard().add(stone, 20 + pxsize * xpos,
                    pxsize * ypos);
            dragController.registerDropController(new FieldDropController(eventbus, stone));
            if (field.getStone().getType() != Type.empty)
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
