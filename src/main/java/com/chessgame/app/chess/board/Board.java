package com.chessgame.app.chess.board;

import java.util.ArrayList;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceType;

public class Board {

	private final ArrayList<Piece> pieceStorage;

	public Board() {
		this.pieceStorage = new ArrayList<>();
	}

	public void add(Piece piece) {
		pieceStorage.add(piece);
	}

	public Piece findPiece(int index) {
		return pieceStorage.get(index);
	}

	public int countPieces(PieceType type, PieceColor color) {
		int count = 0;
		for(Piece piece : pieceStorage) {
			if(piece.verify(type, color)) {
				count++;
			}
		}

		return count;
	}
}
