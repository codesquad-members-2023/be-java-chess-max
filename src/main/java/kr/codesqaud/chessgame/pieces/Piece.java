package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.Piece.Type.*;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN("p"),
        ROOK("r"),
        KNIGHT("n"),
        BISHOP("b"),
        QUEEN("q"),
        KING("k"),
        NO_PIECE("");

        private final String representation;

        Type(final String representation) {
            this.representation = representation;
        }

        public String getWhiteRepresentation() {
            return representation;
        }

        public String getBlackRepresentation() {
            return representation.toUpperCase();
        }
    }

    private final Color color;
    private final Type type;

    private Piece(final Color color, final Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, NO_PIECE);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public String getRepresentation() {
        if (isWhite()) {
            return type.getWhiteRepresentation();
        }
        return type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
}
