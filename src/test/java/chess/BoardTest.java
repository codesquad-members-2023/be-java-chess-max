package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(board.pieceCount()).isEqualTo(32);
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
