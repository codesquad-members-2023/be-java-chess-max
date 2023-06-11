package chess.pieces.bishop;

import static chess.pieces.Color.*;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteBishop extends Bishop {

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.WHITE_BISHOP.getValue();
    }
}
