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

public class Pawn extends Piece {

	private boolean isInitialMove = true;

	private Pawn(final Color color) {
		super(color, Type.PAWN);
	}

	public static Pawn of(Color color) {
		return new Pawn(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from, final Piece target, final List<Rank> board) {
		Set<Position> positions = new HashSet<>();
		boolean isAttack = target.getColor() != getColor() && !(target instanceof Dummy);
		for (Direction direction : Direction.pawnDirection(getColor(), isInitialMove, isAttack)) {
			positions.add(new Position(from.getX() + direction.getXDegree(), from.getY() + direction.getYDegree()));
		}
		if (isInitialMove) {
			isInitialMove = false;
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
