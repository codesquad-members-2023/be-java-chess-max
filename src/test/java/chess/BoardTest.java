package chess;

import static chess.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
	private Board board;

	@BeforeEach
	public void createBoard() {
		board = new Board();
	}

	@DisplayName("체스판을 초기화한다.")
	@Test
	public void initialize() {
		board.initialize();
		String blankRank = appendNewLine("........");
		assertThat(board.showBoard()).isEqualTo(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP")
				+ blankRank + blankRank + blankRank + blankRank
				+ appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"));
	}

	@DisplayName("체스판을 출력한다.")
	@Test
	public void print() {
		board.initialize();
		System.out.println(board.showBoard());
	}
}
