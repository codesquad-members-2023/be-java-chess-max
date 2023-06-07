package chess.pieces;

import chess.color.Color;

public class Pawn {

	private Color color;

	public Pawn() {
		this.color = Color.WHITE;
	}

	public Pawn(final String color) {
		this.color = Color.getColor(color);
	}

	public Color getColor() {
		return color;
	}
}
