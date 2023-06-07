package chess.pieces.king;

import chess.pieces.Piece;
import chess.pieces.Type;

public abstract class King implements Piece {
    public double getScore() {
        return Type.KING.getScore();
    }
}
