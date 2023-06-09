package chess;

import static chess.pieces.Piece.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.pieces.Piece;

class BoardTest {
	private Board board;

	@BeforeEach
	public void createBoard() {
		board = new Board();
	}

	@Test
	@DisplayName("체스 판은 여러 개의 폰을 저장할 수 있다.")
	public void createPawn() {
		Piece whitePawn = Piece.createWhitePawn();
		board.addWhitePawn(whitePawn);
		assertThat(board.size()).isEqualTo(1);

		Piece blackPawn = Piece.createBlackPawn();
		board.addBlackPawn(blackPawn);
		assertThat(board.size()).isEqualTo(2);
	}

	@DisplayName("체스판을 초기화한다.")
	@Test
	public void initialize() {
		board.initialize();
		assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
		assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
	}

	@DisplayName("체스판을 출력한다.")
	@Test
	public void print() {
		board.initialize();
		System.out.println(board.print());
	}
}
