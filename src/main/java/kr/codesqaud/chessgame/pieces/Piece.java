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
    private final String representation;

    private Piece(Color color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, PAWN.getWhiteRepresentation());
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PAWN.getBlackRepresentation());
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, KNIGHT.getWhiteRepresentation());
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, KNIGHT.getBlackRepresentation());
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, ROOK.getWhiteRepresentation());
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, ROOK.getBlackRepresentation());
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, BISHOP.getWhiteRepresentation());
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, BISHOP.getBlackRepresentation());
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, QUEEN.getWhiteRepresentation());
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, QUEEN.getBlackRepresentation());
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, KING.getWhiteRepresentation());
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, KING.getBlackRepresentation());
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
