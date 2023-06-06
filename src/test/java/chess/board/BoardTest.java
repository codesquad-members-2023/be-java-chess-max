package chess.board;

import chess.pieces.Pawn;
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

	@DisplayName("Pawn 인스턴스를 체스보드에 추가할 때 Pawn 인스턴스가 주어지면 체스보드는 Pawn 인스턴스를 가지고 있는다.")
	@Test
	void givenPawns_whenAddPawnsOnBoard_thenBoardHasPawns() {
		// given
		Pawn white = new Pawn("white");
		Pawn black = new Pawn("black");

		// when
		sut.addPiece(white);
		sut.addPiece(black);

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(sut.size()).isEqualTo(2);
			softAssertions.assertThat(sut.findPawn(0)).isEqualTo(white);
			softAssertions.assertThat(sut.findPawn(1)).isEqualTo(black);
		});
	}
}
