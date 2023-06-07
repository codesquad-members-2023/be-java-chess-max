package com.chessgame.app.chess.piece.utill;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;

public class PieceSymbolGenerator {

	private PieceSymbolGenerator() {}

	public static String determine(PieceKind kind, PieceColor color) {
		switch(kind) {
			case KING:
				return determineKingSymbol(color);
			case QUEEN:
				return determineQueenSymbol(color);
			case ROOK:
				return determineRookSymbol(color);
			case BISHOP:
				return determineBishopSymbol(color);
			case KNIGHT:
				return determineKnightSymbol(color);
			case PAWN:
				return determinePawnSymbol(color);
			default:
				return determineEmptySymbol();
		}
	}

	private static String determineKingSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceType.WHITE_KING.getSymbol() : PieceType.BLACK_KING.getSymbol();
	}

	private static String determineQueenSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceType.WHITE_QUEEN.getSymbol() : PieceType.BLACK_QUEEN.getSymbol();
	}

	private static String determineRookSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceType.WHITE_ROOK.getSymbol() : PieceType.BLACK_ROOK.getSymbol();
	}

	private static String determineBishopSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceType.WHITE_BISHOP.getSymbol() : PieceType.BLACK_BISHOP.getSymbol();
	}

	private static String determineKnightSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceType.WHITE_KNIGHT.getSymbol() : PieceType.BLACK_KNIGHT.getSymbol();
	}

	private static String determinePawnSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceType.WHITE_PAWN.getSymbol() : PieceType.BLACK_PAWN.getSymbol();
	}

	private static String determineEmptySymbol() {
		return PieceType.EMPTY.getSymbol();
	}

}
