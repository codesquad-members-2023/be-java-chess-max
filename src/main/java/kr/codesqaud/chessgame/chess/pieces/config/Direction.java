package kr.codesqaud.chessgame.chess.pieces.config;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;

public enum Direction {
    NORTH(1, 0),
    NORTHEAST(1, 1),
    EAST(0, 1),
    SOUTHEAST(-1, 1),
    SOUTH(-1, 0),
    SOUTHWEST(-1, -1),
    WEST(0, -1),
    NORTHWEST(1, -1),

    NNE(2, 1),
    NNW(2, -1),
    SSE(-2, 1),
    SSW(-2, -1),
    EEN(1, 2),
    EES(-1, 2),
    WWN(1, -2),
    WWS(-1, -2);

    private final int yDegree;
    private final int xDegree;

    Direction(final int yDegree, final int xDegree) {
        this.yDegree = yDegree;
        this.xDegree = xDegree;
    }

    public static Direction valueOf(final int y, final int x) {
        // y = 0, x = 0인 경우 예외 발생
        if (y == 0 && x == 0) {
            throw new InvalidMovingPieceException("이동할 수 없는 위치입니다.");
        }

        // 정확히 일치하는 상수가 있는 경우
        for (Direction direction : values()) {
            if (direction.match(y, x)) {
                return direction;
            }
        }

        // 수직인 경우
        if (x == 0) {
            return getSouthAndNorth(y);
        }

        // 수평인 경우
        if (y == 0) {
            return getWestAndEast(x);
        }

        int remainder = x % y;
        // 대각선이 아닌 경우
        if (remainder != 0) {
            throw new InvalidMovingPieceException("이동할 수 없는 위치입니다. y:" + y + ", x : " + x);
        }

        int quotient = x / y; // 몫

        if (quotient == 1) {
            return getNorthEastAndSouthWest(x);
        }

        if (quotient == -1) {
            return getNortWestAndSouthEast(x);
        }

        throw new InvalidMovingPieceException("이동할 수 없는 위치입니다. y:" + y + ", x : " + x);
    }

    private static Direction getSouthAndNorth(final int y) {
        // target.rank - rank > 0 : 북쪽
        // target.rank - rank < 0 : 남쪽
        return y > 0 ? NORTH : SOUTH;
    }

    private static Direction getWestAndEast(final int x) {
        // target.file - file > 0 : 동쪽
        // target.file - file < 0 : 서쪽
        return x > 0 ? EAST : WEST;
    }

    private static Direction getNorthEastAndSouthWest(final int x) {
        // x > 0 : 북동쪽
        // x < 0 : 남서쪽
        return x > 0 ? NORTHEAST : SOUTHWEST;
    }

    private static Direction getNortWestAndSouthEast(final int x) {
        // x > 0 : 남동쪽
        // x < 0 : 북서쪽
        return x > 0 ? SOUTHEAST : NORTHWEST;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }

    public boolean match(int y, int x) {
        return this.yDegree == y && this.xDegree == x;
    }

    public boolean matchDirection(Direction direction) {
        return Objects.equals(this, direction);
    }

    public int getyDegree() {
        return yDegree;
    }

    public int getxDegree() {
        return xDegree;
    }
}
