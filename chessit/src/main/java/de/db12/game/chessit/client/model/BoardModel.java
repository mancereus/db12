package de.db12.game.chessit.client.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.db12.game.chessit.client.model.Stone.Type;

public class BoardModel {

	private Board board;
	private Hand bHand = new Hand();
	private Hand wHand = new Hand();
	private Drop bDrop = new Drop();
	private Drop wDrop = new Drop();

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
		Collections.shuffle(getBHand());
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
		Collections.shuffle(getWHand());

		this.board = new Board(size);
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

	public Board getBoard() {
		return board;
	}

	public Hand getBHand() {
		return bHand;
	}

	public Hand getWHand() {
		return wHand;
	}

	public Drop getbDrop() {
		return bDrop;
	}

	public Drop getwDrop() {
		return wDrop;
	}
	
	
}
