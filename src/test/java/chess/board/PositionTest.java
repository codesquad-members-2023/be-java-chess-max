package chess.board;

import chess.exception.BusinessException;
import chess.exception.ErrorCode;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

	@DisplayName("Position 인스턴스를 생성할 때 위치 정보가 주어지면 인스턴스 생성에 성공한다.")
	@Test
	void givenPositionString_whenCreatePosition_thenReturnsPosition() {
		// given
		String position = "b7";

		// when & then
		assertThatCode(() -> new Position(position)).doesNotThrowAnyException();

		Position actual = new Position(position);
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(actual).isEqualTo(new Position("b7"));
			softAssertions.assertThat(actual.getX()).isEqualTo(1);
			softAssertions.assertThat(actual.getY()).isEqualTo(1);
		});
	}

	@DisplayName("Position 인스턴스를 생성할 때 유효하지 않은 위치 정보가 주어지면 예외를 던진다.")
	@ValueSource(strings = {"i1", "dc", "31", "a0", "a9"})
	@ParameterizedTest
	void givenInvalidPositionString_whenCreatePosition_thenThrowsException(String position) {
		// given

		// when & then
		assertThatThrownBy(() -> new Position(position))
				.isInstanceOf(BusinessException.class)
				.extracting("errorCode")
				.isEqualTo(ErrorCode.INVALID_POSITION);
	}
}
