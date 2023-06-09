package chess.pieces;

import chess.pieces.color.Color;
import chess.pieces.type.Type;

public class Rook extends Piece {

	private Rook(Color color) {
		super(color, Type.ROOK);
	}

	public static Rook of(Color color) {
		return new Rook(color);
	}
}
