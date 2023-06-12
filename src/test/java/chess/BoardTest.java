package chess;

import static chess.utils.StringUtils.*;
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

	@DisplayName("주어진 위치의 기물을 조회할 수 있다.")
	@Test
	public void findPiece() {
		board.initialize();

		assertThat(board.findPiece("a8").getColor()).isEqualTo(Piece.createBlack(Piece.Type.ROOK).getColor());
		assertThat(board.findPiece("a8").getType()).isEqualTo(Piece.createBlack(Piece.Type.ROOK).getType());
		assertThat(board.findPiece("h8").getColor()).isEqualTo(Piece.createBlack(Piece.Type.ROOK).getColor());
		assertThat(board.findPiece("h8").getType()).isEqualTo(Piece.createBlack(Piece.Type.ROOK).getType());
		assertThat(board.findPiece("a1").getColor()).isEqualTo(Piece.createWhite(Piece.Type.ROOK).getColor());
		assertThat(board.findPiece("a1").getType()).isEqualTo(Piece.createWhite(Piece.Type.ROOK).getType());
		assertThat(board.findPiece("h1").getColor()).isEqualTo(Piece.createWhite(Piece.Type.ROOK).getColor());
		assertThat(board.findPiece("h1").getType()).isEqualTo(Piece.createWhite(Piece.Type.ROOK).getType());
	}

	@DisplayName("임의의 기물을 체스판 위에 추가할 수 있다.")
	@Test
	public void move() {
		board.initializeEmpty();

		String position = "b5";
		Piece piece = Piece.createBlack(Piece.Type.ROOK);
		board.move(position, piece);

		assertThat(board.findPiece(position)).isEqualTo(piece);
		System.out.println(board.showBoard());
	}
}
