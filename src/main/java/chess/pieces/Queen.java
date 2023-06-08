package chess.pieces;

import chess.color.Color;
import chess.pieces.type.Type;

public class Queen extends Piece {

	private Queen(Color color) {
		super(color, Type.QUEEN);
	}

	public static Queen of(Color color) {
		return new Queen(color);
	}
}
