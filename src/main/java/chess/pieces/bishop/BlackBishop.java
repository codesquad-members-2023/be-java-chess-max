package chess.pieces.bishop;

import static chess.pieces.Color.BLACK;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackBishop extends Bishop {

    public BlackBishop() {
        super(BLACK);
    }

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.BLACK_BISHOP.getValue();
    }

}
