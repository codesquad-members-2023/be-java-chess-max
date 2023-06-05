package com.chessgame.app.chess.piece;

public class Pawn implements Piece {

	private static final PieceType TYPE = PieceType.PAWN;
	private final PieceColor color;

	public Pawn() {
		this.color = PieceColor.WHITE;
	}

	public Pawn(PieceColor color) {
		this.color = color;
	}

	public boolean verify(PieceType type, PieceColor color) {
		return verifyType(type) && verifyColor(color);
	}

	public boolean verifyType(PieceType type) {
		return TYPE == type;
	}

	public boolean verifyColor(PieceColor color) {
		return this.color == color;
	}
}
