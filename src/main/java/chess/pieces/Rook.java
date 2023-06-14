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
	public Set<Position> movablePositions(final Position from, final Piece target) {
		Set<Position> positions = new HashSet<>();

		for (Direction direction : Direction.linearDirection()) {
			addMovablePositions(positions, from, direction);
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
