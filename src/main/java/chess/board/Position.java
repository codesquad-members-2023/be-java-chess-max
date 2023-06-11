package chess.board;

import chess.exception.BusinessException;
import chess.exception.ErrorCode;

import java.util.Objects;

public class Position {

	private static final int BOARD_SIZE = 8;

	private int x;
	private int y;

	public Position(final String position) {
		verifyPosition(position.toLowerCase());
		this.y = position.toLowerCase().charAt(0) - 'a';
		this.x = Math.abs(Character.getNumericValue(position.charAt(1)) - BOARD_SIZE);
	}

	private void verifyPosition(final String position) {
		if (position.length() != 2) {
			throw new BusinessException(ErrorCode.INVALID_POSITION);
		}

		char col = position.charAt(0);
		char row = position.charAt(1);
		if (col < 'a' || col > 'h' || row < '1' || row > '8') {
			throw new BusinessException(ErrorCode.INVALID_POSITION);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return x == position.x && y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
