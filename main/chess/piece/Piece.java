package chess.piece;

import static chess.piece.Piece.Type.BISHOP;
import static chess.piece.Piece.Type.KING;
import static chess.piece.Piece.Type.KNIGHT;
import static chess.piece.Piece.Type.PAWN;
import static chess.piece.Piece.Type.QUEEN;
import static chess.piece.Piece.Type.ROOK;
import static chess.piece.Piece.Color.BLACK;
import static chess.piece.Piece.Color.WHITE;

public class Piece {

    public enum Color {
        WHITE, BLACK
    }

    public enum Type {
        PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING
    }

    private final Color color;
    private final Type type;
    private final String representation;
    public static final String WHITE_PAWN= "p";
    public static final String BLACK_PAWN = "P";
    public static final String WHITE_KNIGHT= "n";
    public static final String BLACK_KNIGHT = "N";
    public static final String WHITE_ROOK = "r";
    public static final String BLACK_ROOK = "R";
    public static final String WHITE_BISHOP = "b";
    public static final String BLACK_BISHOP = "B";
    public static final String WHITE_QUEEN= "q";
    public static final String BLACK_QUEEN = "Q";
    public static final String WHITE_KING = "k";
    public static final String BLACK_KING = "K";

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN, WHITE_PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN, BLACK_PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT, WHITE_KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT, BLACK_KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK, WHITE_ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK, BLACK_ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP, WHITE_BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP, BLACK_BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN, WHITE_QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN, BLACK_QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING, WHITE_KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, KING, BLACK_KING);
    }

    private Piece(Color color, Type type, String representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
    }

    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public String getRepresentation() {
        return this.representation;
    }

    public boolean isBlack() {
        return this.color.equals(BLACK);
    }

    public boolean isWhite() {
        return this.color.equals(WHITE);
    }

}
