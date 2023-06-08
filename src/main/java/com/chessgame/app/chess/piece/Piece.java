package com.chessgame.app.chess.piece;

import java.util.Objects;

import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceTypeGenerator;

public class Piece {
	private final PieceType type;
	private final Position position;

	public Piece(PieceType type, Position position) {
		this.type = type;
		this.position = position;
	}

	public Piece(PieceKind kind, Position position) {
		this.type = PieceTypeGenerator.generate(kind, PieceColor.WHITE);
		this.position = position;
	}

	public Piece(PieceKind kind, PieceColor color,  Position position) {
		this.type = PieceTypeGenerator.generate(kind, color);
		this.position = position;
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
		return type.getKind() == kind;
	}

	public boolean verifyColor(PieceColor color) {
		return type.getColor() == color;
	}

	public boolean verifyRank(Rank rank) {
		return position.isSameRank(rank);
	}

	public boolean verifyPosition(File file, Rank rank) {
		return position.isSamePosition(file, rank);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Piece)) {
			return false;
		}

		return type.getKind() == ((Piece)obj).getKind()
			&& type.getColor() == ((Piece)obj).getColor()
			&& position.isSamePosition(((Piece)obj).getFile(), ((Piece)obj).getRank());
	}

	@Override
	public int hashCode() {
		return Objects.hash(type.getKind(), type.getColor(), position.getFile(), position.getRank());
	}
}
