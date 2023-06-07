package com.chessgame.app.chess.piece.type;

public enum PieceType {
	WHITE_KING(PieceKind.KING, PieceColor.WHITE, "♔"),
	WHITE_QUEEN(PieceKind.QUEEN, PieceColor.WHITE, "♕"),
	WHITE_ROOK(PieceKind.ROOK, PieceColor.WHITE, "♖"),
	WHITE_BISHOP(PieceKind.BISHOP, PieceColor.WHITE, "♗"),
	WHITE_KNIGHT(PieceKind.KNIGHT, PieceColor.WHITE, "♘"),
	WHITE_PAWN(PieceKind.PAWN, PieceColor.WHITE, "♙"),
	BLACK_KING(PieceKind.KING, PieceColor.BLACK, "♚"),
	BLACK_QUEEN(PieceKind.QUEEN, PieceColor.BLACK, "♛"),
	BLACK_ROOK(PieceKind.ROOK, PieceColor.BLACK, "♜"),
	BLACK_BISHOP(PieceKind.BISHOP, PieceColor.BLACK, "♝"),
	BLACK_KNIGHT(PieceKind.KNIGHT, PieceColor.BLACK, "♞"),
	BLACK_PAWN(PieceKind.PAWN, PieceColor.BLACK, "♟"),
	EMPTY(PieceKind.EMPTY, PieceColor.NO_COLOR, "▭");

	private final PieceKind kind;
	private final PieceColor color;
	private final String symbol;

	PieceType(PieceKind kind, PieceColor color, String symbol) {
		this.kind = kind;
		this.color = color;
		this.symbol = symbol;
	}

	public PieceKind getKind() {
		return kind;
	}

	public PieceColor getColor() {
		return color;
	}

	public String getSymbol() {
		return symbol;
	}
}
