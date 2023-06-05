package com.chessgame.app.chess.piece;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceSymbol;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceSymbolGenerator;

public class Pawn implements Piece {

	private static final PieceType TYPE = PieceType.PAWN;
	private final PieceColor color;
	private final PieceSymbol symbol;

	public Pawn() {
		this.color = PieceColor.WHITE;
		this.symbol = PieceSymbolGenerator.determine(TYPE, this.color);
	}

	public Pawn(PieceColor color) {
		this.color = color;
		this.symbol = PieceSymbolGenerator.determine(TYPE, this.color);
	}

	public String getMark() {
		return symbol.getMark();
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
