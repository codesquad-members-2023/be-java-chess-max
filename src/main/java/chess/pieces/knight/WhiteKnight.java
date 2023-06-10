package chess.pieces.knight;

import static chess.pieces.Color.WHITE;
import static chess.pieces.Representation.WHITE_KNIGHT;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteKnight extends Knight {

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return WHITE_KNIGHT;
    }
}
