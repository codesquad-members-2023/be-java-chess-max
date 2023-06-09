package chess.pieces;

import chess.pieces.color.Color;
import chess.pieces.type.Type;

public class King extends Piece {

	private King(Color color) {
		super(color, Type.KING);
	}

	public static King of(Color color) {
		return new King(color);
	}
}
