package chess.pieces.rook;

import static chess.pieces.Color.WHITE;
import static chess.pieces.Representation.WHITE_ROOK;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteRook extends Rook {

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return WHITE_ROOK;
    }
}
