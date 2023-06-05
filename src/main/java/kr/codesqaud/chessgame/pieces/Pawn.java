package kr.codesqaud.chessgame.pieces;

import java.awt.*;

public class Pawn {
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";

    private final Color color;
    private final String representation;

    public Pawn() {
        this(Color.WHITE, WHITE_REPRESENTATION);
    }

    public Pawn(Color color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
