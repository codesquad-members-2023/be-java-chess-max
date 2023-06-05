package chess.piece;

import chess.Color;

import static chess.Color.WHITE;

public class Pawn {

    private final Color color;

    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}
