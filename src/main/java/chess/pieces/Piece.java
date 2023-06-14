package chess.pieces;

import chess.board.Position;
import chess.exception.BusinessException;
import chess.exception.ErrorCode;
import chess.pieces.color.Color;
import chess.pieces.direction.Direction;
import chess.pieces.type.Type;

import java.util.Set;

public abstract class Piece {

	protected static final int BOARD_SIZE = 8;

	private final Color color;
	private final Type type;

	protected Piece() {
		this.color = Color.WHITE;
		this.type = Type.DUMMY;
	}

	protected Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	public boolean isBlack() {
		return color == Color.BLACK;
	}

	public boolean isWhite() {
		return color == Color.WHITE;
	}

	public void verifyMovePosition(Position to, Piece target) {
		if (to.getX() < 0 || to.getX() >= BOARD_SIZE || to.getY() < 0 || to.getY() >= BOARD_SIZE) {
			throw new BusinessException(ErrorCode.INVALID_POSITION);
		}
		if (!(target instanceof Dummy) && target.getColor() == color) {
			throw new BusinessException(ErrorCode.INVALID_POSITION);
		}
	}

	public Set<Position> movablePositions(Position from, Piece target) {
		return Set.of();
	}

	protected void addMovablePositions(Set<Position> positions, Position current, Direction direction) {
		int x = current.getX();
		int y = current.getY();

		for (int i = 1; i <= BOARD_SIZE; i++) {
			int nextX = x + direction.getXDegree() * i;
			int nextY = y + direction.getYDegree() * i;
			if (!isValidPosition(nextX, nextY)) {
				continue;
			}
			positions.add(new Position(nextX, nextY));
		}
	}

	private boolean isValidPosition(final int x, final int y) {
		return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
	}

	@Override
	public String toString() {
		if (color == Color.BLACK) {
			return String.valueOf(type.getFigure()).toUpperCase();
		}
		return String.valueOf(type.getFigure());
	}
}
