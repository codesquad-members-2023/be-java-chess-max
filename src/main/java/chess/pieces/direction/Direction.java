package chess.pieces.direction;

import chess.pieces.color.Color;

import java.util.Arrays;
import java.util.List;

public enum Direction {

	NORTH(-1, 0),
	NORTH_EAST(-1, 1),
	EAST(0, 1),
	SOUTH_EAST(1, 1),
	SOUTH(1, 0),
	SOUTH_WEST(1, -1),
	WEST(0, -1),
	NORTH_WEST(-1, -1),

	NNE(-2, 1),
	NNW(-2, -1),
	SSE(2, 1),
	SSW(2, -1),
	EEN(-1, 2),
	EES(1, 2),
	WWN(-1, -2),
	WWS(1, -2);

	private int xDegree;
	private int yDegree;

	Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}

	public static List<Direction> linearDirection() {
		return Arrays.asList(NORTH, EAST, SOUTH, WEST);
	}

	public static List<Direction> diagonalDirection() {
		return Arrays.asList(NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST);
	}

	public static List<Direction> everyDirection() {
		return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST);
	}

	public static List<Direction> knightDirection() {
		return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
	}

	public static List<Direction> pawnDirection(Color color) {
		if (color == Color.BLACK) {
			return blackPawnDirection();
		}
		return whitePawnDirection();
	}

	private static List<Direction> whitePawnDirection() {
		return Arrays.asList(NORTH, NORTH_EAST, NORTH_WEST);
	}

	private static List<Direction> blackPawnDirection() {
		return Arrays.asList(SOUTH, SOUTH_EAST, SOUTH_WEST);
	}
}
