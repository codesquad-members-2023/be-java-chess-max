package chess.pieces;

import chess.color.Color;
import chess.pieces.type.Type;

public class Pawn extends Piece {

	private Pawn(final Color color) {
		super(color, Type.PAWN);
	}

	public static Pawn createWhite() {
		return new Pawn(Color.WHITE);
	}

	public static Pawn createBlack() {
		return new Pawn(Color.BLACK);
	}
}
