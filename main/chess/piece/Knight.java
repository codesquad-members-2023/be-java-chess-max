package chess.piece;

import java.util.Objects;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.KNIGHT;

public class Knight implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private Knight(Color color, Position position) {
        this.type = KNIGHT;
        this.color = color;
        this.position = position;
    }

    public static Knight createBlack(Position position) {
        return new Knight(BLACK, position);
    }

    public static Knight createWhite(Position position) {
        return new Knight(WHITE, position);
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
        final Knight knight = (Knight) o;
        return color == knight.color && type == knight.type && Objects.equals(getPosition(), knight.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }
    
}
