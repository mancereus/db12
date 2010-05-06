package de.db12.game.chessit.client;

import java.util.List;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

import de.db12.game.chessit.client.BoardPresenter.Display;
import de.db12.game.chessit.client.model.Board;
import de.db12.game.chessit.client.model.Field;

public class BoardLayout extends Composite implements Display {
    interface MyUiBinder extends UiBinder<DockLayoutPanel, BoardLayout> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    private static BoardResources res = GWT.create(BoardResources.class);

    @UiField
    HasWidgets help;
    @UiField
    HasWidgets whand;
    @UiField
    HasWidgets wdrop;
    @UiField
    HasWidgets bhand;
    @UiField
    HasWidgets bdrop;
    @UiField
    AbsolutePanel boardview;
    private final int size;

    PickupDragController dragController = null;
    private final HandlerManager eventbus;

    public BoardLayout(int pxsize, HandlerManager eventbus) {
        this.size = pxsize;
        this.eventbus = eventbus;
        initWidget(uiBinder.createAndBindUi(this));
        initGame();
    }

    private void initGame() {
        dragController = new PickupDragController(boardview, false);
//        GridConstrainedDropController dropController = new BoardDropController(boardview, eventbus, size, size);
//        dragController.registerDropController(dropController);

    }

    public void setHelp(String name) {
        help.add(new Label(name));
    }

    @Override
    public HasWidgets getBlackDrop() {
        return bdrop;
    }

    @Override
    public HasWidgets getBlackHand() {
        return bhand;
    }

    @Override
    public Panel getBoard() {
        return boardview;
    }

    @Override
    public HasWidgets getHelp() {
        return help;
    }

    @Override
    public HasWidgets getWhiteDrop() {
        return wdrop;
    }

    @Override
    public HasWidgets getWhiteHand() {
        return whand;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<List<String>> handler) {
        return null;
    }

    @Override
    public List<String> getValue() {
        return null;
    }

    @Override
    public void setValue(List<String> value) {
    }

    @Override
    public void setValue(List<String> value, boolean fireEvents) {
    }

    public void showBoard(Board board) {
        // int height = boardview.getOffsetHeight();
        // int width = boardview.getOffsetWidth();
        // int pxsize = Math.max(Math.min(height, width) / 8, 30);
        int pxsize = 120;

        for (Field field : board.getFields()) {
            StoneView stone = new StoneView(field, pxsize);
            boardview.add(stone, pxsize * (field.getX() - board.getXOffset()), pxsize
                    * (field.getY() - board.getYOffset()));
             dragController.registerDropController(new
             FieldDropController(eventbus, stone));
            dragController.makeDraggable(stone);
        }

    }

    public void clearBoard() {
    	dragController.unregisterDropControllers();
        boardview.clear();
    }

}