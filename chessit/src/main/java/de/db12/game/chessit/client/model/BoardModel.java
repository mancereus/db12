package de.db12.game.chessit.client.model;

import com.google.gwt.user.client.Random;

import de.db12.game.chessit.client.model.Stone.Type;

public class BoardModel {

    private final Board board;
    private final Hand bHand = new Hand();
    private final Hand wHand = new Hand();
    private final Drop bDrop = new Drop();
    private final Drop wDrop = new Drop();

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

    private void shuffle(Hand hand) {
        for (int i = 0; i < hand.size(); i++) {
            int pos = Random.nextInt(hand.size());
            int posTo = Random.nextInt(hand.size());
            swap(hand, pos, posTo);

        }

    }

    private void swap(Hand hand, int pos, int posTo) {
        Stone tmp = hand.get(pos);
        hand.set(pos, hand.get(posTo));
        hand.set(posTo, tmp);

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

    public void moveStone(Place origin, Stone stone, Place target) {
    	origin.remove(stone);
        target.add(stone);

    }

}
