package com.chessgame.app.chess.board;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.chessgame.app.chess.piece.Piece;
import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;
import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceKind;
import com.chessgame.app.chess.piece.type.PieceType;

class BoardTest {

	Board board;
	Position whitePawnPosition;
	Position blackPawnPosition;
	Piece whitePawn;
	Piece blackPawn;

	SoftAssertions softAssertions;

	@BeforeEach
	void beforeEach() {
		board = new Board();

		whitePawnPosition = new Position(File.A, Rank.R2);
		blackPawnPosition = new Position(File.A, Rank.R7);

		whitePawn = new Piece(PieceType.WHITE_PAWN);
		blackPawn = new Piece(PieceType.BLACK_PAWN);

		softAssertions = new SoftAssertions();
	}

	@DisplayName("체스판에 체스말를 추가할 수 있고, 위치 정보를 통해 추가된 체스말를 확인할 수 있다.")
	@Test
	void crete() {
		board.put(whitePawnPosition, whitePawn);
		board.put(blackPawnPosition, blackPawn);

		softAssertions.assertThat(board.countPieces(PieceKind.PAWN, PieceColor.WHITE)).isEqualTo(1);
		softAssertions.assertThat(board.findPieceBy(whitePawnPosition)).isEqualTo(whitePawn);

		softAssertions.assertThat(board.countPieces(PieceKind.PAWN, PieceColor.BLACK)).isEqualTo(1);
		softAssertions.assertThat(board.findPieceBy(blackPawnPosition)).isEqualTo(blackPawn);
		softAssertions.assertAll();
	}

	@DisplayName("체스판을 초기화 하면 모든 체스말들이 제자리에 배치된다.")
	@Test
	void initialize() {
		board.initialize();

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
