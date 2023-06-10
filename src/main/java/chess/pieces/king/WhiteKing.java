package chess.pieces.king;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteKing extends King {

    @Override
    public boolean verifyColor(Color color) {
        return Color.WHITE.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return Representation.WHITE_KING;
    }
}
