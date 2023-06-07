package chess.pieces;

import chess.exception.BusinessException;
import chess.exception.ErrorCode;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PawnTest {

	@DisplayName("Pawn 인스턴스를 만들 때 기본 생성자를 호출하면 흰색 Pawn이 생성된다.")
	@Test
	void givenNothing_whenCreatePawn_thenCreatesWhitePawn() {
		// given

		// when
		Pawn pawn = new Pawn();

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(pawn).isNotNull();
			softAssertions.assertThat(pawn.getColor().getValue()).isEqualTo("white");
		});
	}

	@DisplayName("Pawn 인스턴스를 만들 때 올바른 색깔이 문자열로 주어지면 인스턴스 생성에 성공한다.")
	@ValueSource(strings = {"white", "black"})
	@ParameterizedTest
	void givenColor_whenCreatePawn_thenCreatesPawn(String color) {
		// given

		// when
		Pawn pawn = new Pawn(color);

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			 softAssertions.assertThat(pawn).isNotNull();
			 softAssertions.assertThat(pawn.getColor().getValue()).isEqualTo(color);
		});
	}

	@DisplayName("Pawn 인스턴스를 만들 때 유효하지 않은 색깔이 문자열로 주어지면 예외를 던진다.")
	@ValueSource(strings = {"blue", "green", "red"})
	@ParameterizedTest
	void givenInvalidColor_whenCreatePawn_thenThrowsException(String color) {
		// given

		// when & then
		assertThatThrownBy(() -> new Pawn(color))
				.isInstanceOf(BusinessException.class)
				.extracting("errorCode")
				.isEqualTo(ErrorCode.NO_MATCH_COLOR);
	}
}
