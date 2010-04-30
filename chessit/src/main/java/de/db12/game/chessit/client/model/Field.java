package de.db12.game.chessit.client.model;

public class Field implements Place {
	private Stone stone;

	public Field() {
	}

	@Override
	public boolean add(Stone stone) {
		this.stone = stone;
		stone.movePlace(this);
		return true;

	}

	@Override
	public void remove(Stone stone) {
		this.stone = null;

	}
}
