package chess.pieces;

import chess.color.Color;

public abstract class Piece {

	protected final Color color;

	protected Piece() {
		this.color = Color.WHITE;
	}

	protected Piece(Color color) {
		this.color = color;
	}
}
