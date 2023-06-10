package chess.pieces.king;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KingTest {
    @DisplayName("King의 score는 0점입니다")
    @Test
    void getScore() {
        King king = new WhiteKing();
        assertThat(king.getScore()).isEqualTo(0);
        king = new BlackKing();
        assertThat(king.getScore()).isEqualTo(0);
    }
}
