package chess.board;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.board.Board;
import chess.pieces.Pawn;
import chess.color.Color;

class BoardTest {

	@Test
	@DisplayName("흰색 Pawn을 생성해 Board에 추가한다")
	void create() {
		//given
		Board board = new Board();
		Pawn white = new Pawn(Color.WHITE);

		//when
		board.add(white);

		//then
		assertAll(
			() -> assertThat(board.size()).isEqualTo(1),
			() -> assertThat(board.findPawn(0)).isEqualTo(white)
		);
	}
}
