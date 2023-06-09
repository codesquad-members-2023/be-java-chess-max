package chess.piece;

import java.util.Objects;

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
    private Position position;

    private Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public static Piece createBlank(Position position) {
        return new Piece(NONE, BLANK, position);
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

    private static Piece createWhite(Type type, Position position) {
        return new Piece(WHITE, type, position);
    }

    private static Piece createBlack(Type type, Position position) {
        return new Piece(BLACK, type, position);
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

    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Piece piece = (Piece) o;
        return getColor() == piece.getColor() && getType() == piece.getType() && Objects.equals(getPosition(), piece.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getType(), getPosition());
    }

    public enum Color {
        WHITE, BLACK, NONE
    }

    public enum Type {
        PAWN("p", 1.0),
        KNIGHT("n", 2.5),
        ROOK("r", 5.0),
        BISHOP("b", 3.0),
        QUEEN("q", 9.0),
        KING("k", 0.0),
        BLANK(".", 0.0);

        private final String representation;
        private final double point;

        Type(String representation, double point) {
            this.representation = representation;
            this.point = point;
        }

        public double getPoint() {
            return point;
        }
    }

}
