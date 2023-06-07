package chess.pieces;

import chess.color.Color;

public class Pawn extends Piece {

	public Pawn() {
	}

	public Pawn(final Color color) {
		super(color);
	}

	public Pawn(final String color) {
		super(Color.getColor(color));
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return color == Color.WHITE ? "p" : "P";
	}
}
