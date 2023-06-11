package chess.pieces;

import chess.pieces.color.Color;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PawnTest {

	@DisplayName("Pawn 인스턴스를 생성할 때 팩터리 메서드를 통해 생성하면 올바른 Pawn 인스턴스가 생성된다.")
	@ParameterizedTest
	@MethodSource("providePawns")
	void givenNothing_whenCreatePawn_thenCreatesPawn(Color color, String expectedFigure) {
		// given

		// when
		Pawn pawn = Pawn.of(color);

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(pawn.getColor()).isEqualTo(color);
			softAssertions.assertThat(pawn.toString()).isEqualTo(expectedFigure);
		});
	}

	private static Stream<Arguments> providePawns() {
		return Stream.of(
				Arguments.of(Color.BLACK, "P"),
				Arguments.of(Color.WHITE, "p")
		);
	}

	@DisplayName("Pawn의 색깔을 확인할 때 Pawn 인스턴스가 주어지면 흑색 / 백색 여부가 반환된다.")
	@Test
	void givenPawn_whenCheckPieceOfColor_thenReturnsResult() {
		// given
		Pawn pawn = Pawn.of(Color.BLACK);

		// when
		boolean isBlack = pawn.isBlack();
		boolean isWhite = pawn.isWhite();

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(isBlack).isTrue();
			softAssertions.assertThat(isWhite).isFalse();
		});
	}
}
