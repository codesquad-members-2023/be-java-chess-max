package chess.pieces.knight;

import chess.pieces.Piece;
import chess.pieces.Type;

public abstract class Knight implements Piece {

    public double getScore() {
        return Type.KNIGHT.getScore();
    }
}
