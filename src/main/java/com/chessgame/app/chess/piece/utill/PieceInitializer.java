package com.chessgame.app.chess.piece.utill;

import java.util.ArrayList;
import java.util.List;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;

public class PieceInitializer {

	private PieceInitializer() {}

	public static List<Piece> initialWhitePiece() {
		return List.of(
			new Piece(PieceKind.KING, new Position(File.E, Rank.R1)),
			new Piece(PieceKind.QUEEN, new Position(File.D, Rank.R1)),
			new Piece(PieceKind.ROOK, new Position(File.A, Rank.R1)),
			new Piece(PieceKind.ROOK, new Position(File.H, Rank.R1)),
			new Piece(PieceKind.BISHOP, new Position(File.C, Rank.R1)),
			new Piece(PieceKind.BISHOP, new Position(File.F, Rank.R1)),
			new Piece(PieceKind.KNIGHT, new Position(File.B, Rank.R1)),
			new Piece(PieceKind.KNIGHT, new Position(File.G, Rank.R1)),
			new Piece(PieceKind.PAWN, new Position(File.A, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.B, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.C, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.D, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.E, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.F, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.G, Rank.R2)),
			new Piece(PieceKind.PAWN, new Position(File.H, Rank.R2))
		);
	}

	public static List<Piece> initialBlackPiece() {
		return List.of(
			new Piece(PieceKind.KING, PieceColor.BLACK, new Position(File.E, Rank.R8)),
			new Piece(PieceKind.QUEEN, PieceColor.BLACK, new Position(File.D, Rank.R8)),
			new Piece(PieceKind.ROOK, PieceColor.BLACK, new Position(File.A, Rank.R8)),
			new Piece(PieceKind.ROOK, PieceColor.BLACK, new Position(File.H, Rank.R8)),
			new Piece(PieceKind.BISHOP, PieceColor.BLACK, new Position(File.C, Rank.R8)),
			new Piece(PieceKind.BISHOP, PieceColor.BLACK, new Position(File.F, Rank.R8)),
			new Piece(PieceKind.KNIGHT, PieceColor.BLACK, new Position(File.B, Rank.R8)),
			new Piece(PieceKind.KNIGHT, PieceColor.BLACK, new Position(File.G, Rank.R8)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.A, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.B, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.C, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.D, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.E, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.F, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.G, Rank.R7)),
			new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.H, Rank.R7))
		);
	}

	public static List<Piece> initialEmptyPiece() {
		List<Piece> emptyPieces = new ArrayList<>();
		emptyPieces.addAll(initialEmptyPiece(Rank.R3));
		emptyPieces.addAll(initialEmptyPiece(Rank.R4));
		emptyPieces.addAll(initialEmptyPiece(Rank.R5));
		emptyPieces.addAll(initialEmptyPiece(Rank.R6));

		return emptyPieces;
	}

	private static List<Piece> initialEmptyPiece(Rank rank) {
		if(rank.getValue() <= Rank.R2.getValue() || rank.getValue() >= Rank.R7.getValue()) {
			throw new IllegalArgumentException("Empty Piece의 초기 Rank 위치는 R3~R6 까지 입니다. Rank를 다시 입력해 주세요.");
		}

		return List.of(
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.A, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.B, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.C, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.D, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.E, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.F, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.G, rank)),
			new Piece(PieceKind.EMPTY, PieceColor.NO_COLOR, new Position(File.H, rank))
		);
	}

}
