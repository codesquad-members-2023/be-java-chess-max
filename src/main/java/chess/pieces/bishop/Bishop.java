package chess.pieces.bishop;

import chess.pieces.Piece;
import chess.pieces.Type;

public abstract class Bishop implements Piece {

    public double getScore() {
        return Type.BISHOP.getScore();
    }
}
