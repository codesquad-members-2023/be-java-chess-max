package chess.pieces;

public enum Representation {
    WHITE_PAWN("p"), BLACK_PAWN("P"),
    WHITE_ROOK("r"), BLACK_ROOK("R"),
    WHITE_KNIGHT("n"), BLACK_KNIGHT("N"),
    WHITE_BISHOP("b"), BLACK_BISHOP("B"),
    WHITE_QUEEN("q"), BLACK_QUEEN("Q"),
    WHITE_KING("k"), BLACK_KING("K");

    private final String value;

    Representation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
