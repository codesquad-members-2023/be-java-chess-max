package chess.pieces;

public enum Type {
    PAWN(1), ROOK(5), KNIGHT(2.5), BISHOP(3), QUEEN(9), KING(0),BLANK(0);

    private final double score;

    Type(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
