package com.chessgame.app.piece;

public interface Piece {
	public boolean verify(PieceType type, PieceColor color);
	public boolean verifyType(PieceType type);
	public boolean verifyColor(PieceColor color);

}
