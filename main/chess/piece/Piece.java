package chess.piece;

import static chess.piece.Piece.Type.BISHOP;
import static chess.piece.Piece.Type.BLANK;
import static chess.piece.Piece.Type.KING;
import static chess.piece.Piece.Type.KNIGHT;
import static chess.piece.Piece.Type.PAWN;
import static chess.piece.Piece.Type.QUEEN;
import static chess.piece.Piece.Type.ROOK;
import static chess.piece.Piece.Color.WHITE;
import static chess.piece.Piece.Color.BLACK;
import static chess.piece.Piece.Color.NONE;

public class Piece {

    private final Color color;
    private final Type type;

    public static Piece createBlank() {
        return new Piece(NONE, BLANK);
    }

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(KING);
    }

    public static Piece createBlackKing() {
        return createBlack(KING);
    }

    private static Piece createWhite(Type type) {
        return new Piece(WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(BLACK, type);
    }

    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isBlack() {
        return this.color.equals(BLACK);
    }

    public boolean isWhite() {
        return this.color.equals(WHITE);
    }

    public String getRepresentation() {
        if (this.color == WHITE) {
            return this.type.representation;
        }
        if (this.color ==  BLACK) {
            return this.type.representation.toUpperCase();
        }
        return this.type.representation;
    }

    public enum Color {
        WHITE, BLACK, NONE
    }

    public enum Type {
        PAWN("p"),
        KNIGHT("n"),
        ROOK("r"),
        BISHOP("b"),
        QUEEN("q"),
        KING("k"),
        BLANK(".");

        private final String representation;

        Type(String representation) {
            this.representation = representation;
        }
    }
}
