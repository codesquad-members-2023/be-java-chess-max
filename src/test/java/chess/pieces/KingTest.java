package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {

	@DisplayName("이동가능한 위치를 찾을 때 King 인스턴스가 주어지면 이동가능한 위치들이 반환된다.")
	@Test
	void givenKing_whenFindMovablePositions_thenReturnsMovablePositions() {
		// given
		King king = King.of(Color.BLACK);

		Set<Position> positions = king.movablePositions(new Position("c5"), Dummy.of());

		assertThat(positions).containsExactlyInAnyOrder(
				new Position("c6"), // 상
				new Position("b5"), // 좌
				new Position("d5"), // 우
				new Position("c4"), // 하
				new Position("b6"), new Position("d6"), new Position("b4"), new Position("d4")  // 대각선
		);
	}
}
