package chess.pieces;

import chess.board.Board;
import chess.board.Position;
import chess.pieces.color.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {

	@DisplayName("이동가능한 위치를 찾을 때 Knight 인스턴스가 주어지면 이동가능한 위치들이 반환된다.")
	@Test
	void givenKnight_whenFindMovablePositions_thenReturnsMovablePositions() {
		// given
		Board board = new Board();
		board.initialize();
		Knight knight = Knight.of(Color.BLACK);

		Set<Position> positions = knight.movablePositions(new Position("c5"), Dummy.of(), board.getBoard());

		assertThat(positions).containsExactlyInAnyOrder(
				new Position("b7"), new Position("a6"),
				new Position("a4"), new Position("b3"),
				new Position("d3"), new Position("e4"),
				new Position("d7"), new Position("e6")
		);
	}
}
