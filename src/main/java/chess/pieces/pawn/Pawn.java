package chess.pieces.pawn;

import chess.pieces.Color;
import chess.pieces.DefaultPiece;
import chess.pieces.Type;

public abstract class Pawn extends DefaultPiece {


    public Pawn(Color color) {
        super(color);
    }

    public double getScore() {
        return Type.PAWN.getScore();
    }

    public abstract void capturePiece();
}
