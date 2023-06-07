package chess.pieces.queen;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

    @DisplayName("queen의 score는 9입니다.")
    @Test
    void getScore() {
        Queen queen = new WhiteQueen();
        assertThat(queen.getScore()).isEqualTo(9);
        queen = new BlackQueen();
        assertThat(queen.getScore()).isEqualTo(9);
    }
}
