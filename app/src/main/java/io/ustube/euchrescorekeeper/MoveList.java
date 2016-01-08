package io.ustube.euchrescorekeeper;

import java.util.ArrayList;

public class MoveList extends ArrayList<Move> {

    public void removeLast() {
        super.remove(size() - 1);
    }

    public Move getLastMove() {
        return get(size() - 1);
    }
}
