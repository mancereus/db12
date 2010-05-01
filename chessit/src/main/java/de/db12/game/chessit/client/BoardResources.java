package de.db12.game.chessit.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface BoardResources extends ClientBundle {
    public static final BoardResources INSTANCE = GWT.create(BoardResources.class);

    @Source("board.css")
    public BoardCss style();

    interface BoardCss extends CssResource {
        String enterBG();
    }

    // @Source("config.xml")
    // public TextResource initialConfiguration();
    //
    // @Source("manual.pdf")
    // public DataResource ownersManual();

    @Source("images/bauer_black.png")
    ImageResource bpawn();

    @Source("images/bauer_white.png")
    ImageResource wpawn();

    @Source("images/dame_black.png")
    ImageResource bqueen();

    @Source("images/dame_white.png")
    ImageResource wqueen();

    @Source("images/koenig_black.png")
    ImageResource bking();

    @Source("images/koenig_white.png")
    ImageResource wking();

    @Source("images/laeufer_black.png")
    ImageResource bbishop();

    @Source("images/laeufer_white.png")
    ImageResource wbishop();

    @Source("images/springer_black.png")
    ImageResource bknight();

    @Source("images/springer_white.png")
    ImageResource wknight();

    @Source("images/turm_black.png")
    ImageResource brook();

    @Source("images/turm_white.png")
    ImageResource wrook();

    @Source("images/empty.png")
    ImageResource empty();

}