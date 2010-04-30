package de.db12.game.chessit.client.model;

public class Field {
	enum Status {out, reachable, used}
	private final Status type;
	
	
	public Field() {
		type = Status.out;
	}
}
