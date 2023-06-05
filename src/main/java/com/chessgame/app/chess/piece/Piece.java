package com.chessgame.app.chess.piece;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceType;

public interface Piece {
	boolean verify(PieceType type, PieceColor color);
	boolean verifyType(PieceType type);
	boolean verifyColor(PieceColor color);

}
