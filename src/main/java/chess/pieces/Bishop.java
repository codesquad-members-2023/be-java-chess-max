package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Bishop extends Piece {

	private Bishop(Color color) {
		super(color, Type.BISHOP);
	}

	public static Bishop of(Color color) {
		return new Bishop(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from, final Piece target) {
		Set<Position> positions = new HashSet<>();

		for (Direction direction : Direction.diagonalDirection()) {
			addMovablePositions(positions, from, direction);
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
