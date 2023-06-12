package chess.piece;

import java.util.Objects;

import static chess.util.StringUtil.BOARD_END_INDEX;
import static chess.util.StringUtil.BOARD_START_INDEX;

public class Position {

    private final int x;
    private final int y;

    public Position(final int indexX, final int indexY) {
        this.x = indexX + 1;
        this.y = indexY + 1;
    }

    public Position(String position) {
        this.x = position.charAt(0) - 'a' + 1;
        this.y = Character.getNumericValue(position.charAt(1));
    }

    public int getIndexX() {
        return x - 1;
    }

    public int getIndexY() {
        return y - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isValidBoardPosition() {
        return (getIndexX() >= BOARD_START_INDEX && getIndexY() >= BOARD_START_INDEX && getIndexX() <= BOARD_END_INDEX && getIndexY() <= BOARD_END_INDEX);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return getX() == position.getX() && getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
