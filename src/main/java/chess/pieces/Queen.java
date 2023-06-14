package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Queen extends Piece {

	private Queen(Color color) {
		super(color, Type.QUEEN);
	}

	public static Queen of(Color color) {
		return new Queen(color);
	}

	@Override
	public Set<Position> movablePositions(Position from) {
		Set<Position> positions = new HashSet<>();

		for (Direction direction : Direction.everyDirection()) {
			addMovablePositions(positions, from, direction);
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
