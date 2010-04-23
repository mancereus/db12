package de.db12.game.chessit.client;


import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface Pieces extends ClientBundle {

	@Source("images/bauer_black.png")
	ImageResource bauer_black();

	@Source("images/bauer_white.png")
	ImageResource bauer_white();

	@Source("images/dame_black.png")
	ImageResource dame_black();

	@Source("images/dame_white.png")
	ImageResource dame_white();

	@Source("images/koenig_black.png")
	ImageResource koenig_black();

	@Source("images/koenig_white.png")
	ImageResource koenig_white();

	@Source("images/laeufer_black.png")
	ImageResource laeufer_black();

	@Source("images/laeufer_white.png")
	ImageResource laeufer_white();

	@Source("images/springer_black.png")
	ImageResource springer_black();

	@Source("images/springer_white.png")
	ImageResource springer_white();

	@Source("images/turm_black.png")
	ImageResource turm_black();

	@Source("images/turm_white.png")
	ImageResource turm_white();

}
