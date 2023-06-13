package chess.view;

import chess.board.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChessViewTest {

	private ChessView sut = new ChessView();

	@DisplayName("체스판을 초기화할 때 체스판을 출력하면 체스판이 정상적으로 초기화됨을 확인한다.")
	@Test
	void givenInitializedBoard_whenPrintBoard_thenSuccessInitializeBoard() {
		// given
		Board board = new Board();
		board.initialize();

		// when
		String boardFigure = sut.printBoard(board.getBoard());

		// then
		assertThat(boardFigure).isEqualTo(createInitialBoardFigure());
	}

	private String createInitialBoardFigure() {
		StringBuilder figure = new StringBuilder();
		String newLine = System.lineSeparator();
		figure
				.append("RNBQKBNR").append(newLine)
				.append("PPPPPPPP").append(newLine)
				.append("........").append(newLine)
				.append("........").append(newLine)
				.append("........").append(newLine)
				.append("........").append(newLine)
				.append("pppppppp").append(newLine)
				.append("rnbqkbnr");
		return figure.toString();
	}
}
