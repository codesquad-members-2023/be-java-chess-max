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

    private final Color color;
    private final Type type;

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, KING);
    }

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
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

        return this.type.representation.toUpperCase();
    }

    public enum Color {
        WHITE, BLACK
    }

    public enum Type {
        PAWN("p"),
        KNIGHT("n"),
        ROOK("r"),
        BISHOP("b"),
        QUEEN("q"),
        KING("k");

        private final String representation;

        Type(String representation) {
            this.representation = representation;
        }
    }
}
