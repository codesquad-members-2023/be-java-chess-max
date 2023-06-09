package chess.board;

import chess.exception.BusinessException;
import chess.exception.ErrorCode;
import chess.pieces.Piece;
import chess.pieces.color.Color;
import chess.pieces.type.Type;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardTest {

	private Board sut;

	@BeforeEach
	void initBoard() {
		sut = new Board();
		sut.initialize();
	}

	@DisplayName("체스판을 초기화할 때 체스판을 출력하면 체스판이 정상적으로 초기화됨을 확인한다.")
	@Test
	void givenInitializedBoard_whenPrintBoard_thenSuccessInitializeBoard() {
		// given

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

	@DisplayName("기물을 찾을 때 위치정보가 문자열로 주어지면 해당 위치의 기물을 반환한다.")
	@Test
	void givenPosition_whenFindPiece_thenReturnsPiece() {
		// given
		String position = "b8";

		// when
		Piece piece = sut.findPiece(position);

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(piece.getColor()).isEqualTo(Color.BLACK);
			softAssertions.assertThat(piece.getType()).isEqualTo(Type.KNIGHT);
		});
	}

	@DisplayName("기물을 찾을 때 올바르지 않은 위치정보가 문자열로 주어지면 예외를 던진다.")
	@ValueSource(strings = {"i1", "f0", "d9"})
	@ParameterizedTest
	void givenInvalidPosition_whenFindPiece_thenThrowsException(String position) {
		// given

		// when & then
		assertThatThrownBy(() -> sut.findPiece(position))
				.isInstanceOf(BusinessException.class)
				.extracting("errorCode")
				.isEqualTo(ErrorCode.INVALID_POSITION);
	}
}
