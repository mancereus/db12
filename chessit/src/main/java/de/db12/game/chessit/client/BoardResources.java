package de.db12.game.chessit.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface BoardResources extends ClientBundle {
  public static final BoardResources INSTANCE =  GWT.create(BoardResources.class);

  @Source("board.css")
  public BoardCss style();
  
  interface BoardCss extends CssResource {
	  String enterBG();
  }

//  @Source("config.xml")
//  public TextResource initialConfiguration();
//
//  @Source("manual.pdf")
//  public DataResource ownersManual();
  
	@Source("images/big/bauer_black.png")
	ImageResource bpawn();

	@Source("images/big/bauer_white.png")
	ImageResource wpawn();

	@Source("images/big/dame_black.png")
	ImageResource dame_black();

	@Source("images/big/dame_white.png")
	ImageResource dame_white();

	@Source("images/big/koenig_black.png")
	ImageResource bking();

	@Source("images/big/koenig_white.png")
	ImageResource wking();

	@Source("images/big/laeufer_black.png")
	ImageResource bbishop();

	@Source("images/big/laeufer_white.png")
	ImageResource wbishop();

	@Source("images/big/springer_black.png")
	ImageResource springer_black();

	@Source("images/big/springer_white.png")
	ImageResource springer_white();

	@Source("images/big/turm_black.png")
	ImageResource brook();

	@Source("images/big/turm_white.png")
	ImageResource wrook();

}