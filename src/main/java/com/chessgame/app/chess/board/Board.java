package com.chessgame.app.chess.board;

import java.util.ArrayList;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceInitializer;

public class Board {

	private final ArrayList<Piece> pieceStorage;

	public Board() {
		this.pieceStorage = new ArrayList<>();
	}

	public void initialize() {
		pieceStorage.addAll(PieceInitializer.initialWhitePawns());
		pieceStorage.addAll(PieceInitializer.initialBlackPawns());
	}

	public void add(Piece piece) {
		pieceStorage.add(piece);
	}

	public Piece findPiece(int index) {
		return pieceStorage.get(index);
	}

	public int countPieces(PieceType clazz, PieceColor color) {
		int count = 0;
		for(Piece piece : pieceStorage) {
			if(piece.verify(clazz, color)) {
				count++;
			}
		}

		return count;
	}

	public String getResult(Rank rank) {
		StringBuilder sb = new StringBuilder("▭▭▭▭▭▭▭▭");

		for(Piece piece : pieceStorage) {
			if(piece.verifyRank(rank)) {
				int startIndex = piece.getFileValue() - 1;
				sb.replace(startIndex, startIndex + 1, piece.getMark());
			}
		}

		return sb.toString();
	}
}
