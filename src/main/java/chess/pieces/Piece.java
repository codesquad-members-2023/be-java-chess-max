package chess.pieces;

import chess.board.Position;
import chess.exception.BusinessException;
import chess.exception.ErrorCode;
import chess.pieces.color.Color;
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

	public Set<Position> movablePositions(Position from) {
		return Set.of();
	}

	@Override
	public String toString() {
		if (color == Color.BLACK) {
			return String.valueOf(type.getFigure()).toUpperCase();
		}
		return String.valueOf(type.getFigure());
	}
}
