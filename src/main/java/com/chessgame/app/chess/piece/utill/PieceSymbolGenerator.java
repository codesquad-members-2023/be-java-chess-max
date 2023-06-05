package com.chessgame.app.chess.piece.utill;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceSymbol;
import com.chessgame.app.chess.piece.type.PieceType;

public class PieceSymbolGenerator {

	private PieceSymbolGenerator() {}

	public static PieceSymbol determine(PieceType type, PieceColor color) {
		switch(type) {
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
			default:
				return determinePawnSymbol(color);
		}
	}

	private static PieceSymbol determineKingSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceSymbol.WHITE_KING : PieceSymbol.BLACK_KING;
	}

	private static PieceSymbol determineQueenSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceSymbol.WHITE_QUEEN : PieceSymbol.BLACK_QUEEN;
	}

	private static PieceSymbol determineRookSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceSymbol.WHITE_ROOK : PieceSymbol.BLACK_ROOK;
	}

	private static PieceSymbol determineBishopSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceSymbol.WHITE_BISHOP : PieceSymbol.BLACK_BISHOP;
	}

	private static PieceSymbol determineKnightSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceSymbol.WHITE_KNIGHT : PieceSymbol.BLACK_KNIGHT;
	}

	private static PieceSymbol determinePawnSymbol(PieceColor color) {
		return color == PieceColor.WHITE? PieceSymbol.WHITE_PAWN : PieceSymbol.BLACK_PAWN;
	}

}
