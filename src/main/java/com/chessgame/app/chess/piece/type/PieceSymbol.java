package com.chessgame.app.chess.piece.type;

public enum PieceSymbol {
	WHITE_KING("♔"),
	WHITE_QUEEN("♕"),
	WHITE_ROOK("♖"),
	WHITE_BISHOP("♗"),
	WHITE_KNIGHT("♘"),
	WHITE_PAWN("♙"),
	BLACK_KING("♚"),
	BLACK_QUEEN("♛"),
	BLACK_ROOK("♜"),
	BLACK_BISHOP("♝"),
	BLACK_KNIGHT("♞"),
	BLACK_PAWN("♟");

	private final String mark;

	PieceSymbol(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return mark;
	}
}
