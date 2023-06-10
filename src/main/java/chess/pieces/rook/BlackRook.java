package chess.pieces.rook;

import static chess.pieces.Color.BLACK;
import static chess.pieces.Representation.BLACK_ROOK;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackRook extends Rook {

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return BLACK_ROOK;
    }
}
