package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.chess.pieces.Position.createPosition;

import kr.codesqaud.chessgame.chess.pieces.Position;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치값이 주어지고 Position 객체 생성을 요청할때 생성한다.")
    public void createPosition_success() {
        // given
        String position = "a1";
        // when
        Position actual = createPosition(position);
        // then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(actual.toString()).isEqualTo("a1");
        });
    }

    @Test
    @DisplayName("부적절한 위치값이 주어지고 Position 객체 생성을 요청할때 예외가 발생한다")
    public void createPosition_fail() {
        // given
        String p1 = "m1";
        String p2 = "a0";
        String p3 = "a13";
        // when, then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(createPosition(p1).empty()).isTrue();
            softAssertions.assertThat(createPosition(p2).empty()).isTrue();
            softAssertions.assertThat(createPosition(p3).empty()).isTrue();
        });
    }
}
