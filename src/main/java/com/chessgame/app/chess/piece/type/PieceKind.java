package com.chessgame.app.chess.piece.type;

public enum PieceKind {
	KING(0.0), QUEEN(9.0), ROOK(5.0), BISHOP(3.0),
	KNIGHT(2.5), PAWN(1.0), EMPTY(0.0);

	private final double point;

	PieceKind(double point) {
		this.point = point;
	}

	public double getPoint() {
		return point;
	}
}
