package chess.pieces;

import static chess.Color.WHITE;

import chess.Color;

public class WhitePawn extends Pawn {

    @Override
    public boolean verifyPawn(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public PawnRepresentation getRepresentation() {
        return PawnRepresentation.WHITE;
    }
}
