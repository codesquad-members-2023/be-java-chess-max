package chess.pieces.pawn;

import static chess.pieces.Color.WHITE;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhitePawn extends Pawn {

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return Representation.WHITE_PAWN;
    }
}
