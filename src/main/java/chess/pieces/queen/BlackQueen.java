package chess.pieces.queen;

import static chess.pieces.Color.BLACK;
import static chess.pieces.Representation.BLACK_QUEEN;

import chess.pieces.Color;
import chess.pieces.Representation;

public class BlackQueen extends Queen {

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return BLACK_QUEEN;
    }
}
