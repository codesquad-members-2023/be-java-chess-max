package chess.pieces;

import static chess.pieces.PawnRepresentation.P;
import static chess.pieces.PawnRepresentation.p;

import chess.Color;

public record Pawn(Color color) implements Piece {

    public boolean verifyPawn(Color color) {
        return this.color.equals(color);
    }

    public PawnRepresentation getRepresentation() {
        if (color.equals(Color.WHITE)) {
            return p;
        }
        return P;
    }
}
