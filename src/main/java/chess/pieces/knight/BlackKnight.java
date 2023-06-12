package chess.pieces.knight;

import static chess.pieces.Color.BLACK;
import static chess.pieces.Representation.BLACK_KNIGHT;

import chess.pieces.Color;

public class BlackKnight extends Knight {

    public BlackKnight() {
        super(BLACK);
    }

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public String getRepresentation() {
        return BLACK_KNIGHT.getValue();
    }
}
