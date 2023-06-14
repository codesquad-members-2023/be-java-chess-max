package chess.pieces;

import chess.board.Position;
import chess.pieces.color.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {

	@DisplayName("이동가능한 위치를 찾을 때 Queen 인스턴스가 주어지면 이동가능한 위치들이 반환된다.")
	@Test
	void givenQueen_whenFindMovablePositions_thenReturnsMovablePositions() {
		// given
		Queen queen = Queen.of(Color.BLACK);

		Set<Position> positions = queen.movablePositions(new Position("c5"), Dummy.of());

		assertThat(positions).containsExactlyInAnyOrder(
				new Position("b6"), new Position("a7"),
				new Position("d6"), new Position("e7"), new Position("f8"),
				new Position("b4"), new Position("a3"),
				new Position("d4"), new Position("e3"), new Position("f2"), new Position("g1"),
				new Position("c6"), new Position("c7"), new Position("c8"),
				new Position("b5"), new Position("a5"),
				new Position("d5"), new Position("e5"), new Position("f5"), new Position("g5"), new Position("h5"),
				new Position("c4"), new Position("c3"), new Position("c2"), new Position("c1")
		);
	}

}
