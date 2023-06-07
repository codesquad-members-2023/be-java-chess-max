package com.chessgame.app.chess.board;

import java.util.ArrayList;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.utill.PieceInitializer;

public class Board {

	private static final int MAX_SIZE = 8;

	private final ArrayList<Piece> pieceStorage;

	public Board() {
		this.pieceStorage = new ArrayList<>();
	}

	public void initialize() {
		pieceStorage.addAll(PieceInitializer.initialWhitePiece());
		pieceStorage.addAll(PieceInitializer.initialBlackPiece());
		pieceStorage.addAll(PieceInitializer.initialEmptyPiece());
	}

	public void add(Piece piece) {
		pieceStorage.add(piece);
	}

	public Piece findPiece(int index) {
		return pieceStorage.get(index);
	}

	public int countPieces(PieceKind clazz, PieceColor color) {
		int count = 0;
		for(Piece piece : pieceStorage) {
			if(piece.verify(clazz, color)) {
				count++;
			}
		}

		return count;
	}

	public String getResult(Rank rank) {
		StringBuilder sb = new StringBuilder(" ".repeat(MAX_SIZE));

		for(Piece piece : pieceStorage) {
			if(piece.verifyRank(rank)) {
				int startIndex = piece.getFileValue() - 1;
				sb.replace(startIndex, startIndex + 1, piece.getSymbol());
			}
		}

		return sb.toString();
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();

		for(Rank rank : Rank.values()) {
			if(rank == Rank.BLOCK) continue;
			sb.append(getResult(rank)).append(System.lineSeparator());
		}
		return sb.toString();
	}
}
