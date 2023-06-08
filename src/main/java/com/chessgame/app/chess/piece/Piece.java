package com.chessgame.app.chess.piece;

import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceSymbolGenerator;

public class Piece {
	private final PieceKind kind;
	private final PieceColor color;
	private final String symbol;
	private final Position position;

	public Piece(PieceType type, Position position) {
		this.kind = type.getKind();
		this.color = type.getColor();
		this.symbol = type.getSymbol();
		this.position = position;
	}

	public Piece(PieceKind kind, Position position) {
		this.kind = kind;
		this.color = PieceColor.WHITE;
		this.symbol = PieceSymbolGenerator.determine(kind, color);
		this.position = position;
	}

	public Piece(PieceKind kind, PieceColor color,  Position position) {
		this.kind = kind;
		this.color = color;
		this.symbol = PieceSymbolGenerator.determine(kind, color);
		this.position = position;
	}

	public String getSymbol() {
		return symbol;
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

	public boolean verify(PieceKind kind, PieceColor color) {
		return verifyType(kind) && verifyColor(color);
	}

	public boolean verifyType(PieceKind kind) {
		return this.kind == kind;
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
