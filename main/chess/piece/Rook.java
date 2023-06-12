package chess.piece;

import java.util.Objects;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.ROOK;

public class Rook implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private Rook(Color color, Position position) {
        this.type = ROOK;
        this.color = color;
        this.position = position;
    }

    public static Rook createBlack(Position position) {
        return new Rook(BLACK, position);
    }

    public static Rook createWhite(Position position) {
        return new Rook(WHITE, position);
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
        final Rook rook = (Rook) o;
        return color == rook.color && type == rook.type && Objects.equals(getPosition(), rook.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }

}
