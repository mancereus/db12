package de.db12.game.chessit.client.model;

import java.util.List;

public class Board {
	Stone[][] fields;
	List<Stone> stones;
	
	public Board(int size) {
		fields = new Stone[size][size];
	}
	
	public void addStone(int x, int y, Stone stone) {
		fields[x][y] = stone;
		stones.add(stone);
		stone.setPos(x,y);
	}
}
