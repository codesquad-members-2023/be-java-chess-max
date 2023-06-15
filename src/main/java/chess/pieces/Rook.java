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

public class Rook extends Piece {

	private Rook(Color color) {
		super(color, Type.ROOK);
	}

	public static Rook of(Color color) {
		return new Rook(color);
	}

	@Override
	public Set<Position> movablePositions(final Position from, final Piece target, final List<Rank> board) {
		Set<Position> positions = new HashSet<>();

		for (Direction direction : Direction.linearDirection()) {
			addMovablePositions(positions, from, direction, board);
		}

		return positions.stream().collect(Collectors.toUnmodifiableSet());
	}
}
