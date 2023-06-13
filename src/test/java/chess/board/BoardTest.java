package chess.board;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.color.Color;

class BoardTest {

	@Test
	@DisplayName("Board를 초기화하면 black Pawn과 white Pawn이 생성된다")
	public void initialize() {

		//given
		Board board = new Board();

		//when
		board.initialize();

		//then
		assertAll(
			() -> assertThat(board.getPawn(Color.WHITE)).isEqualTo("pppppppp"),
			() -> assertThat(board.getPawn(Color.BLACK)).isEqualTo("PPPPPPPP")
		);
	}
}
