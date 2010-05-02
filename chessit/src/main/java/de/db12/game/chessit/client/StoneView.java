package de.db12.game.chessit.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

import de.db12.game.chessit.client.model.Field;
import de.db12.game.chessit.client.model.Stone;

public class StoneView extends Image {

    private static BoardResources res = GWT.create(BoardResources.class);
    private final Field field;

    public StoneView(Field field) {
        super(getImageResource(field.getStone()));
        this.field = field;
    }

    public static ImageResource getImageResource(Stone stone) {
        if (stone == null)
            return res.empty();
        switch (stone.getType()) {
        case bbishop:
            return res.bbishop();
        case bking:
            return res.bking();
        case bqueen:
            return res.bqueen();
        case bpawn:
            return res.bpawn();
        case brook:
            return res.brook();
        case bknight:
            return res.bknight();
        case wbishop:
            return res.wbishop();
        case wking:
            return res.wking();
        case wqueen:
            return res.wqueen();
        case wpawn:
            return res.wpawn();
        case wrook:
            return res.wrook();
        case wknight:
            return res.wknight();
        case empty:
            return res.empty();
        default:
            break;
        }
        return null;
    }

    public Field getField() {
        return field;
    }
}
