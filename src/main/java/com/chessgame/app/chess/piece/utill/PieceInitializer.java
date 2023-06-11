package com.chessgame.app.chess.piece.utill;

import java.util.HashMap;
import java.util.Map;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;

public class PieceInitializer {

	private PieceInitializer() {}

	public static Map<Position, Piece> initialEmptyBoard() {
		Map<Position, Piece> map = new HashMap<>();

		for(Rank rank : Rank.values()) {
			if(rank == Rank.BLOCK) continue;
			map.putAll(initialEmptyRank(rank));
		}

		return map;
	}

	private static Map<Position, Piece> initialEmptyRank(Rank rank) {
		Map<Position, Piece> map = new HashMap<>();

		for(File file : File.values()) {
			if(file == File.BLOCK) continue;
			map.put(new Position(file, rank), new Piece(PieceType.EMPTY));
		}

		return map;
	}

	public static Map<Position, Piece> initialPiece(PieceColor color) {
		Map<Position, Piece> map = new HashMap<>();

		map.putAll(initialKing(color));
		map.putAll(initialQueen(color));
		map.putAll(initialRook(color));
		map.putAll(initialBishop(color));
		map.putAll(initialKnight(color));
		map.putAll(initialPawn(color));

		return map;
	}

	public static Map<Position, Piece> initialEmptyPiece() {
		Map<Position, Piece> map = new HashMap<>();

		map.putAll(initialEmptyRank(Rank.R3));
		map.putAll(initialEmptyRank(Rank.R4));
		map.putAll(initialEmptyRank(Rank.R5));
		map.putAll(initialEmptyRank(Rank.R6));

		return map;
	}

	private static Map<Position, Piece> initialKing(PieceColor color) {

		Rank rank = determineRankOneOrEight(color);
		PieceType type = PieceTypeGenerator.generate(PieceKind.KING, color);

		return Map.of(new Position(File.E, rank), new Piece(type));
	}

	private static Map<Position, Piece> initialQueen(PieceColor color) {

		Rank rank = determineRankOneOrEight(color);
		PieceType type = PieceTypeGenerator.generate(PieceKind.QUEEN, color);

		return Map.of(new Position(File.D, rank), new Piece(type));
	}

	private static Map<Position, Piece> initialRook(PieceColor color) {

		Rank rank = determineRankOneOrEight(color);
		PieceType type = PieceTypeGenerator.generate(PieceKind.ROOK, color);

		return Map.of(
			new Position(File.A, rank), new Piece(type),
			new Position(File.H, rank), new Piece(type)
		);
	}

	private static Map<Position, Piece> initialBishop(PieceColor color) {

		Rank rank = determineRankOneOrEight(color);
		PieceType type = PieceTypeGenerator.generate(PieceKind.BISHOP, color);

		return Map.of(
			new Position(File.C, rank), new Piece(type),
			new Position(File.F, rank), new Piece(type)
		);
	}

	private static Map<Position, Piece> initialKnight(PieceColor color) {

		Rank rank = determineRankOneOrEight(color);
		PieceType type = PieceTypeGenerator.generate(PieceKind.KNIGHT, color);

		return Map.of(
			new Position(File.B, rank), new Piece(type),
			new Position(File.G, rank), new Piece(type)
		);
	}

	private static Map<Position, Piece> initialPawn(PieceColor color) {

		Rank rank = (color == PieceColor.WHITE)? Rank.R2 : Rank.R7;
		PieceType type = PieceTypeGenerator.generate(PieceKind.PAWN, color);

		Map<Position, Piece> map = new HashMap<>();
		for(File file : File.values()) {
			if(file == File.BLOCK) continue;
			map.put(new Position(file, rank), new Piece(type));
		}

		return map;
	}

	private static Rank determineRankOneOrEight(PieceColor color) {
		return (color == PieceColor.WHITE)? Rank.R1 : Rank.R8;
	}

}
