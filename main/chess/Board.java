package chess;

import chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>(16);
    }

    public void add(final Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int countPawn() {
        return pawns.size();
    }

    public Pawn findPawn(final int index) {
        return pawns.get(index);
    }
}
