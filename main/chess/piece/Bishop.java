package chess.piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.BISHOP;
import static chess.util.StringUtil.BOARD_END_INDEX;
import static chess.util.StringUtil.BOARD_START_INDEX;

public class Bishop implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private Bishop(Color color, Position position) {
        this.type = BISHOP;
        this.color = color;
        this.position = position;
    }

    public static Bishop createBlack(Position position) {
        return new Bishop(BLACK, position);
    }

    public static Bishop createWhite(Position position) {
        return new Bishop(WHITE, position);
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
        List<Position> positions = new ArrayList<>();

        for (int i = BOARD_START_INDEX; i <= BOARD_END_INDEX; i++) {
            positions.add(new Position(position.getIndexX() - i, position.getIndexY() - i));
            positions.add(new Position(position.getIndexX() - i, position.getIndexY() + i));
            positions.add(new Position(position.getIndexX() + i, position.getIndexY() - i));
            positions.add(new Position(position.getIndexX() + i, position.getIndexY() + i));
        }

        return positions.stream().filter(p -> !p.equals(this.position) && p.isValidBoardPosition()).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Bishop bishop = (Bishop) o;
        return color == bishop.color && type == bishop.type && Objects.equals(getPosition(), bishop.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }
}
