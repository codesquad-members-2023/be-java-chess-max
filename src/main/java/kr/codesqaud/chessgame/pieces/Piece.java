package kr.codesqaud.chessgame.pieces;

public class Piece {
    public static final String WHITE_PAWN_REPRESENTATION = "p";
    public static final String BLACK_PAWN_REPRESENTATION = "P";
    public static final String WHITE_KNIGHT_REPRESENTATION = "n";
    public static final String BLACK_KNIGHT_REPRESENTATION = "N";
    public static final String WHITE_ROOK_REPRESENTATION = "r";
    public static final String BLACK_ROOK_REPRESENTATION = "R";
    public static final String WHITE_BISHOP_REPRESENTATION = "b";
    public static final String BLACK_BISHOP_REPRESENTATION = "B";
    public static final String WHITE_QUEEN_REPRESENTATION = "q";
    public static final String BLACK_QUEEN_REPRESENTATION = "Q";
    public static final String WHITE_KING_REPRESENTATION = "k";
    public static final String BLACK_KING_REPRESENTATION = "K";

    private final Color color;
    private final String representation;

    private Piece(Color color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, BLACK_KING_REPRESENTATION);
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
}
