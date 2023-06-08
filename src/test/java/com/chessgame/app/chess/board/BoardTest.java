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
		board.initialize();

		whitePawnPosition = new Position(File.A, Rank.R2);
		blackPawnPosition = new Position(File.A, Rank.R7);

		whitePawn = new Piece(PieceType.WHITE_PAWN, whitePawnPosition);
		blackPawn = new Piece(PieceType.BLACK_PAWN, blackPawnPosition);

		softAssertions = new SoftAssertions();
	}

	@DisplayName("equals 메서드의 오버라이딩이 잘 구현 됐는지 확인")
	@Test
	void testEquals() {
		softAssertions.assertThat(whitePawn).isEqualTo(new Piece(PieceType.WHITE_PAWN, whitePawnPosition));
		softAssertions.assertThat(blackPawn).isEqualTo(new Piece(PieceType.BLACK_PAWN, blackPawnPosition));
		softAssertions.assertAll();
	}

	@DisplayName("equals 메서드의 오버라이딩이 잘 구현 됐는지 확인")
	@Test
	void testHashCode() {
		softAssertions.assertThat(whitePawn.hashCode()).isEqualTo(new Piece(PieceType.WHITE_PAWN, whitePawnPosition).hashCode());
		softAssertions.assertThat(blackPawn.hashCode()).isEqualTo(new Piece(PieceType.BLACK_PAWN, blackPawnPosition).hashCode());
		softAssertions.assertAll();
	}

	@DisplayName("Board에 Piece를 추가할 수 있고, 추가된 Piece를 확인할 수 있다.")
	@Test
	void crete() {
		softAssertions.assertThat(board.countPieces(PieceKind.PAWN, PieceColor.WHITE)).isEqualTo(8);
		softAssertions.assertThat(board.findPiece(PieceType.WHITE_PAWN, whitePawnPosition)).isEqualTo(whitePawn);

		softAssertions.assertThat(board.countPieces(PieceKind.PAWN, PieceColor.BLACK)).isEqualTo(8);
		softAssertions.assertThat(board.findPiece(PieceType.BLACK_PAWN, blackPawnPosition)).isEqualTo(blackPawn);
		softAssertions.assertAll();
	}

	@DisplayName("체스판을 초기화 하면 모든 체스말들이 제자리에 배치된다.")
	@Test
	void initialize() {
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

	@DisplayName("원하는 위치에 있는 Piece를 알아낼 수 있다.")
	@Test
	void findByPosition() {
		assertThat(board.findPiece(whitePawnPosition).getKind()).isEqualTo(PieceKind.PAWN);
	}

}
