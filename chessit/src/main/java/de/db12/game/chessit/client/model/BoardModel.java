package de.db12.game.chessit.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Random;

import de.db12.game.chessit.client.model.Stone.Type;

public class BoardModel {

    private final Board board;
    private final List<Stone> wDrop = new ArrayList<Stone>();
    private final List<Stone> bDrop = new ArrayList<Stone>();
    private final List<Stone> bHand = new ArrayList<Stone>();
    private final List<Stone> wHand = new ArrayList<Stone>();

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
        shuffle(getBHand());
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
        shuffle(getWHand());

        this.board = new Board(size);
        int middlex = size / 2;
        int middley = size / 2;
        getBoard().addStone(middlex, middley - 2, new Stone(Type.bking));
        getBoard().addStone(middlex - 1, middley - 1, new Stone(Type.bpawn));
        getBoard().addStone(middlex, middley - 1, new Stone(Type.bpawn));
        getBoard().addStone(middlex + 1, middley - 1, new Stone(Type.bpawn));

        getBoard().addStone(middlex, middley + 3, new Stone(Type.wking));
        getBoard().addStone(middlex - 1, middley + 2, new Stone(Type.wpawn));
        getBoard().addStone(middlex, middley + 2, new Stone(Type.wpawn));
        getBoard().addStone(middlex + 1, middley + 2, new Stone(Type.wpawn));
    }

    private void shuffle(List<Stone> hand) {
        for (int i = 0; i < hand.size(); i++) {
            int pos = Random.nextInt(hand.size());
            int posTo = Random.nextInt(hand.size());
            swap(hand, pos, posTo);

        }

    }

    private void swap(List<Stone> hand, int pos, int posTo) {
        Stone tmp = hand.get(pos);
        hand.set(pos, hand.get(posTo));
        hand.set(posTo, tmp);

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

    public List<Stone> getbDrop() {
        return bDrop;
    }

    public List<Stone> getwDrop() {
        return wDrop;
    }

    public void moveStone(Place origin, Stone stone, Place target) {
        checkEmpties(origin);
        origin.remove(stone);
        target.add(stone);

    }

    private void checkEmpties(Place origin) {

    }
}
