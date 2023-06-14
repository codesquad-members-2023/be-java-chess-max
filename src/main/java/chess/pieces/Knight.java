package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Knight extends Piece {

	private Knight(Color color) {
		super(color, Type.KNIGHT);
	}

	public static Knight of(Color color) {
		return new Knight(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from, final Piece target) {
		Set<Position> positions = new HashSet<>();

		for (Direction direction : Direction.knightDirection()) {
			positions.add(new Position(from.getX() + direction.getXDegree(), from.getY() + direction.getYDegree()));
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
