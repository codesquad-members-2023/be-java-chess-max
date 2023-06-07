package com.chessgame.app.chess.piece.utill;

import java.util.List;

import com.chessgame.app.chess.piece.Pawn;
import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;

public class PieceInitializer {

	private PieceInitializer() {}

	public static List<Piece> initialWhitePawns() {
		return List.of(
			new Pawn(new Position(File.A, Rank.R2)),
			new Pawn(new Position(File.B, Rank.R2)),
			new Pawn(new Position(File.C, Rank.R2)),
			new Pawn(new Position(File.D, Rank.R2)),
			new Pawn(new Position(File.E, Rank.R2)),
			new Pawn(new Position(File.F, Rank.R2)),
			new Pawn(new Position(File.G, Rank.R2)),
			new Pawn(new Position(File.H, Rank.R2))
		);
	}

	public static List<Piece> initialBlackPawns() {
		return List.of(
			new Pawn(PieceColor.BLACK, new Position(File.A, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.B, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.C, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.D, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.E, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.F, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.G, Rank.R7)),
			new Pawn(PieceColor.BLACK, new Position(File.H, Rank.R7))
		);
	}

}
