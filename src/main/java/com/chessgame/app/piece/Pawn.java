package com.chessgame.app.piece;

public class Pawn {
	private final PieceColor color;

	public Pawn(PieceColor color) {
		this.color = color;
	}

	public boolean verifyColor(PieceColor color) {
		return this.color == color;
	}
}
