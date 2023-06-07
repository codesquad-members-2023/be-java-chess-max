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
        NO_PIECE(".");

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
    private final Position position;

    private Piece(final Color color, final Type type, final Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(PAWN, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(KNIGHT, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(ROOK, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return createWhite(BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return createBlack(BISHOP, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return createWhite(QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return createBlack(QUEEN, position);
    }

    public static Piece createWhiteKing(Position position) {
        return createWhite(KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return createBlack(KING, position);
    }

    public static Piece createBlank(Position position) {
        return new Piece(Color.NOCOLOR, NO_PIECE, position);
    }

    private static Piece createWhite(Type type, Position position) {
        return new Piece(Color.WHITE, type, position);
    }

    private static Piece createBlack(Type type, Position position) {
        return new Piece(Color.BLACK, type, position);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public Position getPosition() {
        return position;
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
