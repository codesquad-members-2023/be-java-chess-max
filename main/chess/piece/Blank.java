package chess.piece;

import chess.exception.EmptyPieceMoveException;

import java.util.List;
import java.util.Objects;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.NONE;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.BLANK;

public class Blank implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private Blank(Position position) {
        this.type = BLANK;
        this.color = NONE;
        this.position = position;
    }

    public static Blank create(Position position) {
        return new Blank(position);
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
    public List<Position> getValidMovePositions() {
        throw new EmptyPieceMoveException();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Blank blank = (Blank) o;
        return color == blank.color && type == blank.type && Objects.equals(getPosition(), blank.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }

}
