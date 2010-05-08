package de.db12.game.chessit.client.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.db12.game.chessit.client.model.Stone.Type;

public class Board {
    Map<Integer, Field> fields = new HashMap<Integer, Field>();
    private final int size;

    public Board(int size) {
        this.size = size;
    }

    public void addStone(int x, int y, Stone stone) {
        Field target = fields.get(x * size + y);
        if (target == null || target.getStone().getType() == Type.empty)
            fields.put(x * size + y, new Field(x, y, stone));
        checkNeighbours(x, y);

    }

    private void checkNeighbours(int x, int y) {
        checkEmpty(x - 1, y - 1);
        checkEmpty(x - 1, y);
        checkEmpty(x - 1, y + 1);
        checkEmpty(x, y - 1);
        checkEmpty(x, y + 1);
        checkEmpty(x + 1, y - 1);
        checkEmpty(x + 1, y);
        checkEmpty(x + 1, y + 1);
    }

    private void checkEmpty(int x, int y) {
        if (fields.get(x * size + y) == null)
            fields.put(x * size + y, new Field(x, y, new Stone(Type.empty)));
    }

    public int getXOffset() {
        int xmin = size;
        for (Field field : fields.values()) {
            if (xmin > field.getX())
                xmin = field.getX();
        }
        return xmin;
    }

    public int getYOffset() {
        int ymin = size;
        for (Field field : fields.values()) {
            if (ymin > field.getY())
                ymin = field.getY();
        }
        return ymin;
    }

    public Collection<Field> getFields() {
        return fields.values();
    }
}
