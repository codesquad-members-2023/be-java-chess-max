package chess.pieces.pawn;

import static chess.pieces.Color.BLACK;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackPawn extends Pawn {


    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.BLACK_PAWN.getValue();
    }
}
