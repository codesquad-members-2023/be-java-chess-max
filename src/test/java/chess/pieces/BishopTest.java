package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BishopTest {

	@DisplayName("이동가능한 위치를 찾을 때 Bishop 인스턴스가 주어지면 이동가능한 위치들이 반환된다.")
	@Test
	void givenBishop_whenFindMovablePositions_thenReturnsMovablePositions() {
		// given
		Bishop bishop = Bishop.of(Color.BLACK);

		Set<Position> positions = bishop.movablePositions(new Position("c5"), Dummy.of());

		assertThat(positions).containsExactlyInAnyOrder(
				new Position("b6"), new Position("a7"),
				new Position("d6"), new Position("e7"), new Position("f8"),
				new Position("b4"), new Position("a3"),
				new Position("d4"), new Position("e3"), new Position("f2"), new Position("g1")
		);
	}
}
