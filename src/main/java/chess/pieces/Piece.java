package chess.pieces;

import chess.pieces.color.Color;
import chess.pieces.type.Type;

public abstract class Piece {

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

	@Override
	public String toString() {
		if (color == Color.BLACK) {
			return String.valueOf(type.getFigure()).toUpperCase();
		}
		return String.valueOf(type.getFigure());
	}
}
