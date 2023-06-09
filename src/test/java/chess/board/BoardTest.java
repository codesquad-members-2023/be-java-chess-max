package chess.board;

import chess.color.Color;
import chess.pieces.type.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

	private Board sut;

	@BeforeEach
	void initBoard() {
		sut = new Board();
	}

	@DisplayName("체스판을 초기화할 때 체스판을 출력하면 체스판이 정상적으로 초기화됨을 확인한다.")
	@Test
	void givenInitializedBoard_whenPrintBoard_thenSuccessInitializeBoard() {
		// given
		sut.initialize();

		// when
		String boardFigure = sut.print();

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

	@DisplayName("기물의 개수를 셀 때 기물의 타입과 색깔이 주어지면 해당 기물의 개수가 반환된다.")
	@MethodSource("provideTypeAndColor")
	@ParameterizedTest
	void givenPieceTypeAndColor_whenCountPieces_thenReturnsCountOfPieces(Type type, Color color, int expectedCount) {
		// given
		sut.initialize();

		// when
		int count = sut.countPieces(type, color);

		// then
		assertThat(count).isEqualTo(expectedCount);
	}

	private static Stream<Arguments> provideTypeAndColor() {
		return Stream.of(
				Arguments.of(Type.PAWN, Color.BLACK, 8),
				Arguments.of(Type.PAWN, Color.WHITE, 8),
				Arguments.of(Type.ROOK, Color.BLACK, 2),
				Arguments.of(Type.ROOK, Color.WHITE, 2),
				Arguments.of(Type.KNIGHT, Color.BLACK, 2),
				Arguments.of(Type.KNIGHT, Color.WHITE, 2),
				Arguments.of(Type.BISHOP, Color.BLACK, 2),
				Arguments.of(Type.BISHOP, Color.WHITE, 2),
				Arguments.of(Type.QUEEN, Color.BLACK, 1),
				Arguments.of(Type.QUEEN, Color.WHITE, 1),
				Arguments.of(Type.KING, Color.BLACK, 1),
				Arguments.of(Type.KING, Color.WHITE, 1)
		);
	}
}
