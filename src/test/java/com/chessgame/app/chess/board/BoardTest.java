package com.chessgame.app.chess.board;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;

class BoardTest {

	@DisplayName("Board에 Piece를 추가할 수 있고, 추가된 Piece를 확인할 수 있다.")
	@Test
	void crete() {
		Board board = new Board();

		Piece whitePawn = new Piece(PieceKind.PAWN, PieceColor.WHITE, new Position(File.BLOCK, Rank.BLOCK));
		board.add(whitePawn);
		assertThat(board.countPieces(PieceKind.PAWN, PieceColor.WHITE)).isEqualTo(1);
		assertThat(board.findPiece(0)).isEqualTo(whitePawn);

		Piece blackPawn = new Piece(PieceKind.PAWN, PieceColor.BLACK, new Position(File.BLOCK, Rank.BLOCK));
		board.add(blackPawn);
		assertThat(board.countPieces(PieceKind.PAWN, PieceColor.BLACK)).isEqualTo(1);
		assertThat(board.findPiece(1)).isEqualTo(blackPawn);
	}

	@DisplayName("체스판을 초기화 하면 모든 체스말들이 제자리에 배치된다.")
	@Test
	void initialize() {
		Board board = new Board();

		board.initialize();

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(board.getResult(Rank.R1)).isEqualTo("♖♘♗♕♔♗♘♖");
		softAssertions.assertThat(board.getResult(Rank.R2)).isEqualTo("♙♙♙♙♙♙♙♙");
		softAssertions.assertThat(board.getResult(Rank.R3)).isEqualTo("▭▭▭▭▭▭▭▭");
		softAssertions.assertThat(board.getResult(Rank.R4)).isEqualTo("▭▭▭▭▭▭▭▭");
		softAssertions.assertThat(board.getResult(Rank.R5)).isEqualTo("▭▭▭▭▭▭▭▭");
		softAssertions.assertThat(board.getResult(Rank.R6)).isEqualTo("▭▭▭▭▭▭▭▭");
		softAssertions.assertThat(board.getResult(Rank.R7)).isEqualTo("♟♟♟♟♟♟♟♟");
		softAssertions.assertThat(board.getResult(Rank.R8)).isEqualTo("♜♞♝♛♚♝♞♜");
		softAssertions.assertAll();
	}
}
