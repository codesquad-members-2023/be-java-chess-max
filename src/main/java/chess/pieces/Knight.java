package chess.pieces;

import chess.color.Color;
import chess.pieces.type.Type;

public class Knight extends Piece {

	private Knight(Color color) {
		super(color, Type.KNIGHT);
	}

	public static Knight of(Color color) {
		return new Knight(color);
	}
}
