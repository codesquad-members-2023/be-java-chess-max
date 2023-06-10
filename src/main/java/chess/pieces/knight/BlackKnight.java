package chess.pieces.knight;

import static chess.pieces.Color.BLACK;
import static chess.pieces.Representation.BLACK_KNIGHT;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackKnight extends Knight {

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return BLACK_KNIGHT;
    }
}
