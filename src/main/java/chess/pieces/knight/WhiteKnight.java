package chess.pieces.knight;

import static chess.pieces.Color.WHITE;
import static chess.pieces.Representation.WHITE_KNIGHT;

import chess.pieces.Color;

public class WhiteKnight extends Knight {

    public WhiteKnight() {
        super(WHITE);
    }

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public String getRepresentation() {
        return WHITE_KNIGHT.getValue();
    }
}
