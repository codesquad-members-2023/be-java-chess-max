package kr.codesqaud.chessgame.pieces;

public enum Type {
    PAWN("p", 1.0),
    ROOK("r", 5.0),
    KNIGHT("n", 2.5),
    BISHOP("b", 3.0),
    QUEEN("q", 9.0),
    KING("k", 0.0),
    NO_PIECE(".", 0.0);

    private final String representation;
    private final double defaultPoint;

    Type(final String representation, final double defaultPoint) {
        this.representation = representation;
        this.defaultPoint = defaultPoint;
    }

    public String getWhiteRepresentation() {
        return representation;
    }

    public String getBlackRepresentation() {
        return representation.toUpperCase();
    }

    public double getDefaultPoint() {
        return defaultPoint;
    }
}
