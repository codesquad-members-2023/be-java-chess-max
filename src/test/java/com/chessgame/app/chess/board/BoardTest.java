package com.chessgame.app.chess.board;

import static org.assertj.core.api.Assertions.*;

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
	void put() {
		board.put(whitePawnPosition, whitePawn);
		board.put(blackPawnPosition, blackPawn);

		softAssertions.assertThat(board.countPieces(PieceKind.PAWN, PieceColor.WHITE)).isEqualTo(1);
		softAssertions.assertThat(board.findPieceBy(whitePawnPosition)).isEqualTo(whitePawn);

		softAssertions.assertThat(board.countPieces(PieceKind.PAWN, PieceColor.BLACK)).isEqualTo(1);
		softAssertions.assertThat(board.findPieceBy(blackPawnPosition)).isEqualTo(blackPawn);
		softAssertions.assertAll();
	}

	@DisplayName("체스판의 같은 위치에 체스말을 추가하면 새로 추가한 체스말로 교체된다. 기존에 있던 체스말은 사라진다.")
	@Test
	void putInSamePosition() {
		board.put(whitePawnPosition, whitePawn);
		board.put(whitePawnPosition, blackPawn);

		assertThat(board.findPieceBy(whitePawnPosition)).isEqualTo(blackPawn);
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

	@DisplayName("문자열 위치 정보를 통해 원하는 위치에 있는 체스말을 찾을 수 있다.")
	@Test
	void findPieceByString() {
		board.initialize();

		softAssertions.assertThat(board.findPieceBy("a1").getType()).isEqualTo(PieceType.WHITE_ROOK);
		softAssertions.assertThat(board.findPieceBy("b1").getType()).isEqualTo(PieceType.WHITE_KNIGHT);

		softAssertions.assertThat(board.findPieceBy("e8").getType()).isEqualTo(PieceType.BLACK_KING);
		softAssertions.assertThat(board.findPieceBy("f8").getType()).isEqualTo(PieceType.BLACK_BISHOP);

		softAssertions.assertThat(board.findPieceBy("h2").getType()).isEqualTo(PieceType.WHITE_PAWN);
		softAssertions.assertThat(board.findPieceBy("a7").getType()).isEqualTo(PieceType.BLACK_PAWN);

		softAssertions.assertThat(board.findPieceBy("a3").getType()).isEqualTo(PieceType.EMPTY);
		softAssertions.assertThat(board.findPieceBy("c5").getType()).isEqualTo(PieceType.EMPTY);

		softAssertions.assertAll();
	}

}
