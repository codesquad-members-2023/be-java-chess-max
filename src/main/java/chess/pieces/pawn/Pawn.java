package chess.pieces.pawn;

import chess.pieces.Piece;
import chess.pieces.Type;

public abstract class Pawn implements Piece {
    public double getScore() {
        return Type.PAWN.getScore();
    }
}
