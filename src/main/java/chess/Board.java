package chess;

import chess.pieces.Piece;
import java.util.ArrayList;

public class Board {

    private final ArrayList<Piece> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }
}
