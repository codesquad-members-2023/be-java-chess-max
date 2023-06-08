package chess;

import static chess.pieces.Pawn.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.pieces.Pawn;

class BoardTest {
	private Board board;

	@BeforeEach
	public void createBoard() {
		board = new Board();
	}

	@Test
	@DisplayName("체스 판은 여러 개의 폰을 저장할 수 있다.")
	public void createPawn() {
		Pawn whitePawn = new Pawn(WHITE_COLOR, WHITE_REPRESENTATION);
		board.addWhitePawn(whitePawn);
		assertThat(board.size()).isEqualTo(1);

		Pawn blackPawn = new Pawn(BLACK_COLOR, BLACK_REPRESENTATION);
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
}