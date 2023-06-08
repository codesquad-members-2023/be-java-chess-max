package com.chessgame.app.chess.piece.utill;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;

public class PieceTypeGenerator {

	private PieceTypeGenerator() {}

	public static PieceType generate(PieceKind kind, PieceColor color) {
		switch(kind) {
			case KING:
				return determineKingType(color);
			case QUEEN:
				return determineQueenType(color);
			case ROOK:
				return determineRookType(color);
			case BISHOP:
				return determineBishopType(color);
			case KNIGHT:
				return determineKnightType(color);
			case PAWN:
				return determinePawnType(color);
			default:
				return determineEmptyType();
		}
	}

	private static PieceType determineKingType(PieceColor color) {
		return (color == PieceColor.WHITE)? PieceType.WHITE_KING : PieceType.BLACK_KING;
	}

	private static PieceType determineQueenType(PieceColor color) {
		return (color == PieceColor.WHITE)? PieceType.WHITE_QUEEN : PieceType.BLACK_QUEEN;
	}

	private static PieceType determineRookType(PieceColor color) {
		return (color == PieceColor.WHITE)? PieceType.WHITE_ROOK : PieceType.BLACK_ROOK;
	}

	private static PieceType determineBishopType(PieceColor color) {
		return (color == PieceColor.WHITE)? PieceType.WHITE_BISHOP : PieceType.BLACK_BISHOP;
	}

	private static PieceType determineKnightType(PieceColor color) {
		return (color == PieceColor.WHITE)? PieceType.WHITE_KNIGHT : PieceType.BLACK_KNIGHT;
	}

	private static PieceType determinePawnType(PieceColor color) {
		return (color == PieceColor.WHITE)? PieceType.WHITE_PAWN : PieceType.BLACK_PAWN;
	}

	private static PieceType determineEmptyType() {
		return PieceType.EMPTY;
	}


}
