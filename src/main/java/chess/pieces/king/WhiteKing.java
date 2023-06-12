package chess.pieces.king;

import static chess.pieces.Color.WHITE;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteKing extends King {

    public WhiteKing() {
        super(WHITE);
    }

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.WHITE_KING.getValue();
    }
}
