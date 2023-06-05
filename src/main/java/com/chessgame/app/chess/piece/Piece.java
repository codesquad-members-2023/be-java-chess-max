package com.chessgame.app.chess.piece;

public interface Piece {
	boolean verify(PieceType type, PieceColor color);
	boolean verifyType(PieceType type);
	boolean verifyColor(PieceColor color);

}
