package chess.pieces;

public enum Representation {
    WHITE_PAWN("p"), BLACK_PAWN("P"),
    WHITE_ROOK("r"), BLACK_ROOK("R"),
    WHITE_KNIGHT("k"), BLACK_KNIGHT("K"),
    WHITE_BISHOP("b"), BLACK_BISHOP("B"),
    WHITE_QUEEN("q"), BLACK_QUEEN("Q"),
    WHITE_KING("k"), BLACK_KING("K");

    private final String representation;

    Representation(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
