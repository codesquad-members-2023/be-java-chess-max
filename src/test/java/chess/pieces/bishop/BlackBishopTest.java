package chess.pieces.bishop;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackBishopTest {

    @DisplayName("인증 할 color가 Black면 true 아니면 false")
    @Test
    void verifyColor() {
        BlackBishop blackBishop = new BlackBishop();
        assertThat(blackBishop.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackBishop.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("representation.BlackBishop 반환 한다.")
    @Test
    void getRepresentation() {
        BlackBishop blackBishop = new BlackBishop();

        assertThat(blackBishop.getRepresentation()).isEqualTo(
                Representation.BLACK_BISHOP.getValue());
    }
}
