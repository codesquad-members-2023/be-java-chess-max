package chess.pieces.pawn;

import static chess.pieces.Color.BLACK;

import chess.pieces.Color;

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
