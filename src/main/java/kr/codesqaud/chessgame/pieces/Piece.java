package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.Piece.Type.BISHOP;
import static kr.codesqaud.chessgame.pieces.Piece.Type.KING;
import static kr.codesqaud.chessgame.pieces.Piece.Type.KNIGHT;
import static kr.codesqaud.chessgame.pieces.Piece.Type.NO_PIECE;
import static kr.codesqaud.chessgame.pieces.Piece.Type.PAWN;
import static kr.codesqaud.chessgame.pieces.Piece.Type.QUEEN;
import static kr.codesqaud.chessgame.pieces.Piece.Type.ROOK;

import java.util.Objects;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN("p", 1.0),
        ROOK("r", 5.0),
        KNIGHT("n", 2.5),
        BISHOP("b", 3.0),
        QUEEN("q", 9.0),
        KING("k", 0.0),
        NO_PIECE(".", 0.0);

        private final String representation;
        private final double defaultPoint;

        Type(final String representation, final double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public String getWhiteRepresentation() {
            return representation;
        }

        public String getBlackRepresentation() {
            return representation.toUpperCase();
        }

        public double getDefaultPoint() {
            return defaultPoint;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece) o;
        return getColor() == piece.getColor() && getType() == piece.getType() && Objects.equals(getPosition(),
            piece.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getType(), getPosition());
    }

    @Override
    public String toString() {
        return "Piece{" +
            "color=" + color +
            ", type=" + type +
            ", position=" + position +
            '}';
    }
}
