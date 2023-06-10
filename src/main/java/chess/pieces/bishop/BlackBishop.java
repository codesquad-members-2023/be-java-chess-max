package chess.pieces.bishop;

import static chess.pieces.Color.BLACK;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackBishop extends Bishop {

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return Representation.BLACK_BISHOP;
    }

}
