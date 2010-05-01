package de.db12.game.chessit.client.event;

import com.google.gwt.event.shared.GwtEvent;

import de.db12.game.chessit.client.model.Field;
import de.db12.game.chessit.client.model.Stone;

public class MoveStoneEvent extends GwtEvent<MoveStoneEventHandler> {
    private static final Type TYPE = new Type<MoveStoneEventHandler>();

    private final Field target;

    private final Stone stone;

    public MoveStoneEvent(Field target, Stone stone) {
        this.target = target;
        this.stone = stone;
    }

    // public MoveStoneEvent(Widget dropTarget, Widget draggable) {
    // // TODO Auto-generated constructor stub
    // }

    public static Type getType() {
        return TYPE;
    }

    public Field getTarget() {
        return target;
    }

    public Stone getStone() {
        return stone;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(MoveStoneEventHandler handler) {
        handler.onStoneMoved(this);

    }
}