package de.db12.game.chessit.client.model;


public class Board {
	Field[][] fields;
	
	public Board(int size) {
		fields = new Field[size][size];
	}
	
	public void addStone(int x, int y, Stone stone) {
		fields[x][y].add(stone);
	}
}
