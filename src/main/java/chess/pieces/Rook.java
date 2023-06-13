package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Rook extends Piece {

	private Rook(Color color) {
		super(color, Type.ROOK);
	}

	public static Rook of(Color color) {
		return new Rook(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from) {
		Set<Position> positions = new HashSet<>();
		int x = from.getX();
		int y = from.getY();

		for (Direction direction : Direction.linearDirection()) {
			for (int i = 1; i <= BOARD_SIZE; i++) {
				int nextX = x + direction.getXDegree() * i;
				int nextY = y + direction.getYDegree() * i;
				if (!isValidPosition(nextX, nextY)) {
					continue;
				}
				positions.add(new Position(nextX, nextY));
			}
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}

	private boolean isValidPosition(final int x, final int y) {
		return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
	}
}
