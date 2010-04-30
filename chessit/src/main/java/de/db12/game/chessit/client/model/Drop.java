package de.db12.game.chessit.client.model;

import java.util.HashSet;


public class Drop extends HashSet<Stone> implements Place {
	private static final long serialVersionUID = 1L;

	public Drop() {
	}

	@Override
	public boolean add(Stone stone) {
		super.add(stone);
		stone.movePlace(this);
		return true;

	}

	@Override
	public void remove(Stone stone) {
		super.remove(stone);

	}
}
