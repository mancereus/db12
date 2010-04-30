package de.db12.game.chessit.client.model;


public class Board {
	Field[][] fields;
	
	public Board(int size) {
		fields = new Field[size][size];
	}
	
	public void addStone(int x, int y, Stone stone) {
		if (fields[x][y] == null)
			fields[x][y] = new Field();
		fields[x][y].add(stone);
	}
}
