package com.chessgame.app.chess.board;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.chessgame.app.chess.piece.Pawn;
import com.chessgame.app.chess.piece.PieceColor;
import com.chessgame.app.chess.piece.PieceType;

class BoardTest {

	@DisplayName("Board에 Piece를 추가할 수 있고, 추가된 Piece를 확인할 수 있다.")
	@Test
	void crete() {
		Board board = new Board();

		Pawn whitePawn = new Pawn(PieceColor.WHITE);
		board.add(whitePawn);
		assertThat(board.countPieces(PieceType.PAWN, PieceColor.WHITE)).isEqualTo(1);
		assertThat(board.findPiece(0)).isEqualTo(whitePawn);

		Pawn blackPawn = new Pawn(PieceColor.BLACK);
		board.add(blackPawn);
		assertThat(board.countPieces(PieceType.PAWN, PieceColor.BLACK)).isEqualTo(1);
		assertThat(board.findPiece(1)).isEqualTo(blackPawn);
	}
}
