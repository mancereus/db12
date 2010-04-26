package de.db12.game.chessit.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dev.util.collect.Lists;

public class BoardModel {

	private int size;
	private Stone[][] board;
	private List<Stone> player1Hand = new ArrayList<Stone>();
	private List<Stone> player2Hand = new ArrayList<Stone>();

	public BoardModel(int size) {
		this.size = size;
		board = new Stone[size][size];
	}
	
	
}
