package com.chessgame.app.chess.piece;

import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceType;

public interface Piece {
	String getMark();
	File getFile();
	int getFileValue();
	Rank getRank();
	int getRankValue();
	boolean verify(PieceType clazz, PieceColor color);
	boolean verifyType(PieceType clazz);
	boolean verifyColor(PieceColor color);
	boolean verifyRank(Rank rank);
	boolean verifyPosition(File file, Rank rank);

}
