package chess.pieces.pawn;

import static chess.pieces.Color.WHITE;

import chess.pieces.Color;

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
