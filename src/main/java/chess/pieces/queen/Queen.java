package chess.pieces.queen;

import chess.pieces.Piece;
import chess.pieces.Type;

public abstract class Queen implements Piece {
    public double getScore() {
        return Type.QUEEN.getScore();
    }
}
