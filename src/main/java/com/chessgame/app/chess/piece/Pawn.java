package com.chessgame.app.chess.piece;

import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceSymbol;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceSymbolGenerator;

public class Pawn {

	private static final PieceType TYPE = PieceType.PAWN;
	private final PieceColor color;
	private final PieceSymbol symbol;
	private final Position position;

	public Pawn(Position position) {
		this.color = PieceColor.WHITE;
		this.symbol = PieceSymbolGenerator.determine(TYPE, this.color);
		this.position = position;
	}

	public Pawn(PieceColor color, Position position) {
		this.color = color;
		this.symbol = PieceSymbolGenerator.determine(TYPE, this.color);
		this.position = position;
	}

	public String getMark() {
		return symbol.getMark();
	}

	public File getFile() {
		return position.getFile();
	}

	public int getFileValue() {
		return getFile().getValue();
	}

	public Rank getRank() {
		return position.getRank();
	}

	public int getRankValue() {
		return getRank().getValue();
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

	public boolean verifyRank(Rank rank) {
		return position.isSameRank(rank);
	}

	public boolean verifyPosition(File file, Rank rank) {
		return position.isSamePosition(file, rank);
	}
}
