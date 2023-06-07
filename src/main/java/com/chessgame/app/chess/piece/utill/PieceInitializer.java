package com.chessgame.app.chess.piece.utill;

import java.util.List;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceType;

public class PieceInitializer {

	private PieceInitializer() {}

	public static List<Piece> initialWhitePiece() {
		return List.of(
			new Piece(PieceType.KING, new Position(File.E, Rank.R1)),
			new Piece(PieceType.QUEEN, new Position(File.D, Rank.R1)),
			new Piece(PieceType.ROOK, new Position(File.A, Rank.R1)),
			new Piece(PieceType.ROOK, new Position(File.H, Rank.R1)),
			new Piece(PieceType.BISHOP, new Position(File.C, Rank.R1)),
			new Piece(PieceType.BISHOP, new Position(File.F, Rank.R1)),
			new Piece(PieceType.KNIGHT, new Position(File.B, Rank.R1)),
			new Piece(PieceType.KNIGHT, new Position(File.G, Rank.R1)),
			new Piece(PieceType.PAWN, new Position(File.A, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.B, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.C, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.D, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.E, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.F, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.G, Rank.R2)),
			new Piece(PieceType.PAWN, new Position(File.H, Rank.R2))
		);
	}

	public static List<Piece> initialBlackPiece() {
		return List.of(
			new Piece(PieceType.KING, PieceColor.BLACK, new Position(File.E, Rank.R8)),
			new Piece(PieceType.QUEEN, PieceColor.BLACK, new Position(File.D, Rank.R8)),
			new Piece(PieceType.ROOK, PieceColor.BLACK, new Position(File.A, Rank.R8)),
			new Piece(PieceType.ROOK, PieceColor.BLACK, new Position(File.H, Rank.R8)),
			new Piece(PieceType.BISHOP, PieceColor.BLACK, new Position(File.C, Rank.R8)),
			new Piece(PieceType.BISHOP, PieceColor.BLACK, new Position(File.F, Rank.R8)),
			new Piece(PieceType.KNIGHT, PieceColor.BLACK, new Position(File.B, Rank.R8)),
			new Piece(PieceType.KNIGHT, PieceColor.BLACK, new Position(File.G, Rank.R8)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.A, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.B, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.C, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.D, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.E, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.F, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.G, Rank.R7)),
			new Piece(PieceType.PAWN, PieceColor.BLACK, new Position(File.H, Rank.R7))
		);
	}

}
