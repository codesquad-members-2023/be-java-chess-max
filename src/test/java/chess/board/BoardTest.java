package chess.board;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

	private Board sut;

	@BeforeEach
	void initBoard() {
		sut = new Board();
	}

	@DisplayName("체스판을 초기화할 때 체스판을 출력하면 검은색 Pawn과 흰색 Pawn이 각각 8개씩 존재한다.")
	@Test
	void givenInitializedBoard_whenPrintBoard_thenBoardContainsPawns() {
		// given
		sut.initialize();

		// when
		String boardFigure = sut.print();

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(boardFigure).contains("PPPPPPPP");
			softAssertions.assertThat(boardFigure).contains("pppppppp");
		});
	}
}
