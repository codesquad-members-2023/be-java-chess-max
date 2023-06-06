package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    @DisplayName("initialize: 체스 판을 p와 P로 구분하여 초기화한다.")
    @Test
    void initialize() throws Exception {
        final Board board = new Board();
        board.initialize();

        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }
}