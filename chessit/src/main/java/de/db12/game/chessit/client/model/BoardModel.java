package de.db12.game.chessit.client.model;

import java.util.ArrayList;
import java.util.List;

import de.db12.game.chessit.client.model.Stone.Type;

public class BoardModel {

	private Board board;
	private List<Stone> bHand = new ArrayList<Stone>();
	private List<Stone> wHand = new ArrayList<Stone>();

	public BoardModel(int size) {
		getBHand().add(new Stone(Type.bknight));
		getBHand().add(new Stone(Type.bknight));
		getBHand().add(new Stone(Type.brook));
		getBHand().add(new Stone(Type.brook));
		getBHand().add(new Stone(Type.bbishop));
		getBHand().add(new Stone(Type.bbishop));
		getBHand().add(new Stone(Type.bqueen));
		getBHand().add(new Stone(Type.bpawn));
		getBHand().add(new Stone(Type.bpawn));
		getBHand().add(new Stone(Type.bpawn));

		getWHand().add(new Stone(Type.wknight));
		getWHand().add(new Stone(Type.wknight));
		getWHand().add(new Stone(Type.wrook));
		getWHand().add(new Stone(Type.wrook));
		getWHand().add(new Stone(Type.wbishop));
		getWHand().add(new Stone(Type.wbishop));
		getWHand().add(new Stone(Type.wqueen));
		getWHand().add(new Stone(Type.wpawn));
		getWHand().add(new Stone(Type.wpawn));
		getWHand().add(new Stone(Type.wpawn));

		setBoard(new Board(size));
		int middlex = size/2;
		int middley = size/2;
		getBoard().addStone(middlex, middley -2, new Stone(Type.bking));
		getBoard().addStone(middlex-1, middley -1, new Stone(Type.bpawn));
		getBoard().addStone(middlex, middley -1, new Stone(Type.bpawn));
		getBoard().addStone(middlex+1, middley -1, new Stone(Type.bpawn));

		getBoard().addStone(middlex, middley +2, new Stone(Type.wking));
		getBoard().addStone(middlex-1, middley +1, new Stone(Type.wpawn));
		getBoard().addStone(middlex, middley +1, new Stone(Type.wpawn));
		getBoard().addStone(middlex+1, middley +1, new Stone(Type.wpawn));
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public List<Stone> getBHand() {
		return bHand;
	}


	public List<Stone> getWHand() {
		return wHand;
	}
	
	
}
