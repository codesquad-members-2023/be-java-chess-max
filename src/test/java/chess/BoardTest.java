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
		verifyPawn(WHITE_COLOR, 1);
		verifyPawn(BLACK_COLOR, 2);
	}

	private void verifyPawn(String color, int size) {
		Pawn pawn = new Pawn(color);
		board.add(pawn);
		assertThat(board.size()).isEqualTo(size);
		assertThat(board.findPawnColor(size-1)).isEqualTo(color);
	}
}