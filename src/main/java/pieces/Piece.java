package pieces;

import java.util.List;
import java.util.Objects;

public abstract class Piece {
    private final Color color;
    private final Type type;
    private final Position position;

    protected Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean matchType(Type type) {
        return this.type.equals(type);
    }

    public boolean isPawn() {
        return type.equals(Type.PAWN);
    }

    public double getPoint(List<Piece> remainPieces) {
        if (!isPawn()) {
            return type.defaultPoint;
        }
        for (Piece piece : remainPieces) {
            // 세로줄에 Pawn이 있는 경우 0.5점
            if (matchPawnWithVerticalLine(piece)) {
                return Type.PAWN_HALF_POINT;
            }
        }
        return type.defaultPoint;
    }

    private boolean matchPawnWithVerticalLine(Piece piece) {
        return piece.isPawn() && this.position.matchVerticalPosition(piece.position);
    }

    public char getRepresentation() {
        if (color.equals(Color.BLACK)) {
            return type.getBlackRepresentation();
        }
        return type.getWhiteRepresentation();
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean matchColor(Color color) {
        return this.color.equals(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (color != piece.color) return false;
        if (type != piece.type) return false;
        return Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private static final double PAWN_HALF_POINT = 0.5;

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }

        public double getDefaultPoint() {
            return this.defaultPoint;
        }
    }
}
