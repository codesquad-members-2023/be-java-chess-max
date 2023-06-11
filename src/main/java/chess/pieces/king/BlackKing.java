package chess.pieces.king;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackKing extends King {

    @Override
    public boolean verifyColor(Color color) {
        return Color.BLACK.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.BLACK_KING.getValue();
    }
}
