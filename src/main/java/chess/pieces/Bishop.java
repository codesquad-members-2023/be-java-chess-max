package chess.pieces;

import chess.color.Color;
import chess.pieces.type.Type;

public class Bishop extends Piece {

	private Bishop(Color color) {
		super(color, Type.BISHOP);
	}

	public static Bishop of(Color color) {
		return new Bishop(color);
	}
}
