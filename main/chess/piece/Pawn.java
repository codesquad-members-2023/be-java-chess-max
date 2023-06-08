package chess.piece;

import chess.Color;

import static chess.Color.WHITE;

public class Pawn implements Piece {

    private final Color color;
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";

    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public String getRepresentation() {
        if (this.color == WHITE) {
            return WHITE_REPRESENTATION;
        }
        return BLACK_REPRESENTATION;
    }

}
