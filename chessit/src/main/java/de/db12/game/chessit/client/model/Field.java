package de.db12.game.chessit.client.model;

public class Field implements Place {
    private Stone stone;
    private final int xpos;
    private final int ypos;

    public Field(int x, int y, Stone stone) {
        this.xpos = x;
        this.ypos = y;
        this.stone = stone;
    }

    @Override
    public boolean add(Stone stone) {
        this.stone = stone;
        stone.movePlace(this);
        return true;

    }

    @Override
    public void remove(Stone stone) {
        this.stone = null;

    }

    public Stone getStone() {
        return stone;

    }

    public int getY() {
        return ypos;
    }

    public int getX() {
        return xpos;
    }
}