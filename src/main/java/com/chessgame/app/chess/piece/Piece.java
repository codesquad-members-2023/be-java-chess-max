package com.chessgame.app.chess.piece;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceTypeGenerator;

public class Piece {
	private final PieceType type;

	public Piece(PieceKind kind) {
		this.type = PieceTypeGenerator.generate(kind, PieceColor.WHITE);
	}

	public Piece(PieceKind kind, PieceColor color) {
		this.type = PieceTypeGenerator.generate(kind, color);
	}

	public Piece(PieceType type) {
		this.type = type;
	}

	public PieceType getType() {
		return type;
	}

	public PieceKind getKind() {
		return type.getKind();
	}

	public PieceColor getColor() {
		return type.getColor();
	}

	public String getSymbol() {
		return type.getSymbol();
	}

	public double getPoint() {
		return getKind().getPoint();
	}

	public boolean verify(PieceKind kind, PieceColor color) {
		return verifyKind(kind) && verifyColor(color);
	}

	public boolean verifyKind(PieceKind kind) {
		return type.getKind() == kind;
	}

	public boolean verifyColor(PieceColor color) {
		return type.getColor() == color;
	}

}
