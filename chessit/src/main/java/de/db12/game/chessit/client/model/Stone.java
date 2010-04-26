package de.db12.game.chessit.client.model;

public class Stone {
	enum Type {bpawn,bking, bqueen, bbishop, bknight, brook}
	private final Type type;
	
	public Stone(Type type) {
		this.type = type;
	}
	public Type getType() {
		return type;
	}
}
