package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Pawn extends Piece {

	private boolean isInitialMove = true;

	private Pawn(final Color color) {
		super(color, Type.PAWN);
	}

	public static Pawn of(Color color) {
		return new Pawn(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from) {
		Set<Position> positions = new HashSet<>();

		for (Direction direction : Direction.pawnDirection(getColor(), isInitialMove)) {
			positions.add(new Position(from.getX() + direction.getXDegree(), from.getY() + direction.getYDegree()));
		}
		if (isInitialMove) {
			isInitialMove = false;
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
