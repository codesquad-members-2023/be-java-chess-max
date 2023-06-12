package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 나이트가 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositions() {
        Knight knight = Knight.createWhite(new Position("a1"));
        assertThat(knight.getValidMovePositions()).containsExactlyInAnyOrder(new Position("b3"), new Position("c2"));

        knight.setPosition(new Position("b1"));
        assertThat(knight.getValidMovePositions()).containsExactlyInAnyOrder(new Position("a3"), new Position("c3"), new Position("d2"));
    }

}
