package chess.pieces.rook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RookTest {

    @DisplayName("rook의 score는 5입니다.")
    @Test
    void getScore() {
        Rook r = new WhiteRook();
        assertThat(r.getScore()).isEqualTo(5);
        r = new BlackRook();
        assertThat(r.getScore()).isEqualTo(5);
    }
}
