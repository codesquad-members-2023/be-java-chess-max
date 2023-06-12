package kr.codesqaud.chessgame.pieces.config;

import java.util.Arrays;
import java.util.List;

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

    private final int y;
    private final int x;

    Direction(final int y, final int x) {
        this.y = y;
        this.x = x;
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
        return this.y == y && this.x == x;
    }
}
