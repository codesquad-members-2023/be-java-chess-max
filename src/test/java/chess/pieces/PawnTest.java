package chess.pieces;

import chess.color.Color;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PawnTest {

	@DisplayName("Pawn 인스턴스를 생성할 때 팩터리 메서드를 통해 생성하면 올바른 Pawn 인스턴스가 생성된다.")
	@ParameterizedTest
	@MethodSource("providePawns")
	void givenNothing_whenCreatePawn_thenCreatesPawn(Pawn pawn, Color expectedColor, String expectedFigure) {
		// given

		// when & then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(pawn.getColor()).isEqualTo(expectedColor);
			softAssertions.assertThat(pawn.toString()).isEqualTo(expectedFigure);
		});
	}

	private static Stream<Arguments> providePawns() {
		return Stream.of(
				Arguments.of(Pawn.createBlack(), Color.BLACK, "P"),
				Arguments.of(Pawn.createWhite(), Color.WHITE, "p")
		);
	}
}
