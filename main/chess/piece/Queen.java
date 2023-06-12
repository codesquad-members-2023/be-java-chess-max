package chess.piece;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.QUEEN;
import static chess.util.StringUtil.BOARD_END_INDEX;
import static chess.util.StringUtil.BOARD_START_INDEX;

public class Queen implements Piece {

    private final Color color;
    private final Type type;
    private Position position;

    private Queen(Color color, Position position) {
        this.type = QUEEN;
        this.color = color;
        this.position = position;
    }

    public static Queen createBlack(Position position) {
        return new Queen(BLACK, position);
    }

    public static Queen createWhite(Position position) {
        return new Queen(WHITE, position);
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
        final Set<Position> positions = Direction.everyDirection()
                .stream()
                .map(direction -> new Position(direction.getxDegree() + position.getIndexX(), direction.getyDegree() + position.getIndexY()))
                .filter(Position::isValidBoardPosition)
                .collect(Collectors.toSet());

        for (int i = BOARD_START_INDEX; i <= BOARD_END_INDEX; i++) {
            positions.add(new Position(position.getIndexX() - i, position.getIndexY() - i));
            positions.add(new Position(position.getIndexX() - i, position.getIndexY() + i));
            positions.add(new Position(position.getIndexX() + i, position.getIndexY() - i));
            positions.add(new Position(position.getIndexX() + i, position.getIndexY() + i));
            positions.add(new Position(position.getIndexX(), i));
            positions.add(new Position(i, position.getIndexY()));
        }

        return positions.stream().filter(p -> !p.equals(this.position) && p.isValidBoardPosition()).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Queen queen = (Queen) o;
        return color == queen.color && type == queen.type && Objects.equals(getPosition(), queen.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, getPosition());
    }

}
