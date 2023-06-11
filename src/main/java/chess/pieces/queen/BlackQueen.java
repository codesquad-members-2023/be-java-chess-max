package chess.pieces.queen;

import static chess.pieces.Color.BLACK;
import static chess.pieces.Representation.BLACK_QUEEN;

import chess.pieces.Color;

public class BlackQueen extends Queen {

    @Override
    public boolean verifyColor(Color color) {
        return BLACK.equals(color);
    }

    @Override
    public String getRepresentation() {
        return BLACK_QUEEN.getValue();
    }
}
