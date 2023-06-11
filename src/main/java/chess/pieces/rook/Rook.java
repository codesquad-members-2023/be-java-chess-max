package chess.pieces.rook;

import chess.pieces.Piece;
import chess.pieces.Type;

public abstract class Rook implements Piece {

    public double getScore() {
        return Type.ROOK.getScore();
    }
}
