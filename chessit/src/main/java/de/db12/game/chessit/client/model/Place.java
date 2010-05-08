package de.db12.game.chessit.client.model;

public interface Place {

    boolean add(Stone stone);

    void remove(Stone stone);

    Stone getStone();

}
