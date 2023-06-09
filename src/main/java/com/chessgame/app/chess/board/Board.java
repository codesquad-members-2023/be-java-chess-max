package com.chessgame.app.chess.board;

import java.util.HashMap;
import java.util.Map;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;
import com.chessgame.app.chess.piece.utill.PieceInitializer;

public class Board {

	private static final int MAX_SIZE = 8;

	private final Map<Position, Piece> pieceStorage = new HashMap<>();

	public Board() {
		this.pieceStorage.putAll(PieceInitializer.initialEmptyBoard());
	}

	public void initialize() {
		pieceStorage.clear();
		pieceStorage.putAll(PieceInitializer.initialPiece(PieceColor.WHITE));
		pieceStorage.putAll(PieceInitializer.initialPiece(PieceColor.BLACK));
		pieceStorage.putAll(PieceInitializer.initialEmptyPiece());
	}

	public void put(Position position, Piece piece) {
		pieceStorage.put(position, piece);
	}

	public Piece findPieceBy(Position position) {
		return pieceStorage.get(position);
	}

	public int countPieces(PieceKind kind, PieceColor color) {
		int count = 0;
		for(Piece piece : pieceStorage.values()) {
			if(piece.verify(kind, color)) {
				count++;
			}
		}

		return count;
	}

	public int countPieces(PieceType type) {
		return countPieces(type.getKind(), type.getColor());
	}

	public String getResult(Rank rank) {
		StringBuilder sb = new StringBuilder(" ".repeat(MAX_SIZE));

		for(Map.Entry<Position, Piece> entry : pieceStorage.entrySet()) {
			if(entry.getKey().verifyRank(rank)) {
				int startIndex = entry.getKey().getFileValue() - 1;
				sb.replace(startIndex, startIndex + 1, entry.getValue().getSymbol());
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
