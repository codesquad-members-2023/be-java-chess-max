package chess.pieces.knight;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KnightTest {

    @DisplayName("knight의 score는 2.5입니다.")
    @Test
    void getScore() {
        Knight knight = new WhiteKnight();
        assertThat(knight.getScore()).isEqualTo(2.5);
        knight = new BlackKnight();
        assertThat(knight.getScore()).isEqualTo(2.5);
    }
}
