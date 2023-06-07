package pieces;

public class Piece {

    private static final String BLACK_COLOR = "black";
    private static final String WHITE_COLOR = "white";
    private static final String PAWN_TYPE = "pawn";
    private static final String ROOK_TYPE = "rook";
    private static final String KNIGHT_TYPE = "knight";
    private static final String BISHOP_TYPE = "bishop";
    private static final String QUEEN_TYPE = "queen";
    private static final String KING_TYPE = "king";
    private static final String BLACK_PAWN_FIGURE = "P";
    private static final String BLACK_ROOK_FIGURE = "R";
    private static final String BLACK_KNIGHT_FIGURE = "N";
    private static final String BLACK_BISHOP_FIGURE = "B";
    private static final String BLACK_QUEEN_FIGURE = "Q";
    private static final String BLACK_KING_FIGURE = "K";
    private static final String WHITE_PAWN_FIGURE = "p";
    private static final String WHITE_ROOK_FIGURE = "r";
    private static final String WHITE_KNIGHT_FIGURE = "n";
    private static final String WHITE_BISHOP_FIGURE = "b";
    private static final String WHITE_QUEEN_FIGURE = "q";
    private static final String WHITE_KING_FIGURE = "k";

    private final String color;
    private final String type;
    private final String figure;

    private Piece(String color, String type, String figure) {
        this.color = color;
        this.type = type;
        this.figure = figure;
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, PAWN_TYPE, BLACK_PAWN_FIGURE);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK_COLOR, ROOK_TYPE, BLACK_ROOK_FIGURE);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, KNIGHT_TYPE, BLACK_KNIGHT_FIGURE);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK_COLOR, BISHOP_TYPE, BLACK_BISHOP_FIGURE);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK_COLOR, QUEEN_TYPE, BLACK_QUEEN_FIGURE);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK_COLOR, KING_TYPE, BLACK_KING_FIGURE);
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, PAWN_TYPE, WHITE_PAWN_FIGURE);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE_COLOR, ROOK_TYPE, WHITE_ROOK_FIGURE);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, KNIGHT_TYPE, WHITE_KNIGHT_FIGURE);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE_COLOR, BISHOP_TYPE, WHITE_BISHOP_FIGURE);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE_COLOR, QUEEN_TYPE, WHITE_QUEEN_FIGURE);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE_COLOR, KING_TYPE, WHITE_KING_FIGURE);
    }

    public boolean isBlackPawn() {
        return color.equals(BLACK_COLOR) && type.equals(PAWN_TYPE);
    }

    public boolean isWhitePawn() {
        return color.equals(WHITE_COLOR) && type.equals(PAWN_TYPE);
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getFigure() {
        return figure;
    }
}
