package chess.pieces;

import chess.board.Position;
import chess.board.Rank;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class King extends Piece {

	private King(Color color) {
		super(color, Type.KING);
	}

	public static King of(Color color) {
		return new King(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from, final Piece target, final List<Rank> board) {
		Set<Position> movablePosition = new HashSet<>();

		for (Direction direction : Direction.everyDirection()) {
			movablePosition.add(new Position(from.getX() + direction.getXDegree(), from.getY() + direction.getYDegree()));
		}

		return movablePosition.stream().collect(Collectors.toUnmodifiableSet());
	}
}
