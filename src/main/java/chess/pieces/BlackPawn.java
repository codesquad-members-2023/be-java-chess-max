package chess.pieces;

import static chess.Color.BLACK;

import chess.Color;

public class BlackPawn extends Pawn {


    @Override
    public boolean verifyPawn(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public PawnRepresentation getRepresentation() {
        return PawnRepresentation.BLACK;
    }
}
