package chess.piece;

import java.util.Objects;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.KING;

public class King implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private King(Color color, Position position) {
        this.type = KING;
        this.color = color;
        this.position = position;
    }

    public static King createBlack(Position position) {
        return new King(BLACK, position);
    }

    public static King createWhite(Position position) {
        return new King(WHITE, position);
    }

    @Override
    public boolean isColor(final Color color) {
        return this.color.equals(color);
    }

    @Override
    public boolean isType(final Type type) {
        return this.type.equals(type);
    }

    @Override
    public String getRepresentation() {
        if (this.color == WHITE) {
            return type.getRepresentation();
        }
        if (this.color ==  BLACK) {
            return type.getRepresentation().toUpperCase();
        }
        return type.getRepresentation();
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public double getPoint() {
        return this.type.getPoint();
    }

    @Override
    public void setPosition(final Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final King king = (King) o;
        return color == king.color && type == king.type && Objects.equals(getPosition(), king.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }

}
