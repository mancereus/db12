package de.db12.game.chessit.client;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.event.shared.HandlerManager;

import de.db12.game.chessit.client.event.MoveStoneEvent;

public class FieldDropController extends SimpleDropController {
    private static BoardResources res = BoardResources.INSTANCE;
    private StoneView image;
    private final HandlerManager eventbus;
    private final StoneView field;

    public FieldDropController(HandlerManager eventbus, StoneView field) {
        super(field);
        this.field = field;
        this.eventbus = eventbus;

    }

    @Override
    public void onEnter(DragContext context) {
        super.onEnter(context);
        image = (StoneView) context.draggable;
    }

    @Override
    public void onDrop(DragContext context) {
        super.onDrop(context);
        eventbus.fireEvent(new MoveStoneEvent(image.getPlace(), image.getPlace().getStone(), field.getPlace()));
    }
}
