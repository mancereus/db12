package de.db12.game.chessit.client.model;

public class Stone {
    public enum Type {
        bpawn, bking, bqueen, bbishop, bknight, brook, wpawn, wking, wqueen, wbishop, wknight, wrook, empty
    }

    private final Type type;

    public Stone(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}