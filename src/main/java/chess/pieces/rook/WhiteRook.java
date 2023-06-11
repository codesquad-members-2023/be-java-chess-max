package chess.pieces.rook;

import static chess.pieces.Color.WHITE;
import static chess.pieces.Representation.WHITE_ROOK;

import chess.pieces.Color;

public class WhiteRook extends Rook {

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public String getRepresentation() {
        return WHITE_ROOK.getValue();
    }
}
