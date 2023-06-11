package chess.pieces.bishop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BishopTest {

    @DisplayName("Bishop의 score 는 3점입니다.")
    @Test
    void getScore() {
        Bishop bishop = new BlackBishop();
        assertThat(bishop.getScore()).isEqualTo(3);
        bishop = new WhiteBishop();
        assertThat(bishop.getScore()).isEqualTo(3);
    }

}
