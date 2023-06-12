package chess.piece;

import java.util.Objects;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.PAWN;

public class Pawn implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private Pawn(Color color, Position position) {
        this.type = PAWN;
        this.color = color;
        this.position = position;
    }

    public static Pawn createBlack(Position position) {
        return new Pawn(BLACK, position);
    }

    public static Pawn createWhite(Position position) {
        return new Pawn(WHITE, position);
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
        final Pawn pawn = (Pawn) o;
        return color == pawn.color && type == pawn.type && Objects.equals(getPosition(), pawn.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }

}
