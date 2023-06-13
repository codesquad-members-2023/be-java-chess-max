package chess.pieces.bishop;

import static chess.pieces.Color.WHITE;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteBishop extends Bishop {

    public WhiteBishop() {
        super(WHITE);
    }

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.WHITE_BISHOP.getValue();
    }
}
