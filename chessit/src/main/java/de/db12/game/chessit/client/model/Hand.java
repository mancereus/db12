package de.db12.game.chessit.client.model;

import java.util.ArrayList;


public class Hand extends ArrayList<Stone> implements Place {
	private static final long serialVersionUID = 1L;

	public Hand() {
	}

	@Override
	public boolean add(Stone stone) {
		super.add(stone);
		return true;

	}

	@Override
	public void remove(Stone stone) {
		super.remove(stone);

	}
}
