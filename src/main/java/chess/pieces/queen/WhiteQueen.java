package chess.pieces.queen;

import static chess.pieces.Color.WHITE;
import static chess.pieces.Representation.WHITE_QUEEN;

import chess.pieces.Color;
import chess.pieces.Representation;

public class WhiteQueen extends Queen {

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public Representation getRepresentation() {
        return WHITE_QUEEN;
    }
}
