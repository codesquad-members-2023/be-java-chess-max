package chess.piece;

public enum Type {

    PAWN("p", 1.0),
    KNIGHT("n", 2.5),
    ROOK("r", 5.0),
    BISHOP("b", 3.0),
    QUEEN("q", 9.0),
    KING("k", 0.0),
    BLANK(".", 0.0);

    private final String representation;
    private final double point;

    Type(String representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    public String getRepresentation() {
        return representation;
    }

    public double getPoint() {
        return point;
    }

}
