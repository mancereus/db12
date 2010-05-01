package de.db12.game.chessit.client;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;

import de.db12.game.chessit.client.event.MoveStoneEvent;

public class BoardDropController extends GridConstrainedDropController {
    private static BoardResources res = BoardResources.INSTANCE;
    private Image image;
    private final HandlerManager eventbus;

    public BoardDropController(AbsolutePanel dropTarget, HandlerManager eventbus, int gridX, int gridY) {
        super(dropTarget, gridX, gridY);
        this.eventbus = eventbus;

    }

    @Override
    public void onEnter(DragContext context) {
        super.onEnter(context);
        image = (Image) context.draggable;
        image.addStyleName(res.style().border());
    }

    @Override
    public void onDrop(DragContext context) {
        super.onDrop(context);
        image.removeStyleName(res.style().border());
        eventbus.fireEvent(new MoveStoneEvent(context.dropController.getDropTarget(), context.draggable));
    }
}
