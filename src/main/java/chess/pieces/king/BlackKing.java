package chess.pieces.king;

import static chess.pieces.Color.BLACK;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackKing extends King {

    public BlackKing() {
        super(BLACK);
    }

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.BLACK_KING.getValue();
    }
}
