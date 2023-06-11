package chess.pieces.bishop;

import static org.assertj.core.api.Assertions.*;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhiteBishopTest {

    @DisplayName("인증 할 color가 화이트면 true 아니면 false")
    @Test
    void verifyColor() {
        WhiteBishop whiteBishop = new WhiteBishop();
        assertThat(whiteBishop.verifyColor(Color.WHITE)).isTrue();
        assertThat(whiteBishop.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("representation.WHITE_BISHOP 반환 한다.")
    @Test
    void getRepresentation() {
        WhiteBishop whiteBishop = new WhiteBishop();

        assertThat(whiteBishop.getRepresentation()).isEqualTo(Representation.WHITE_BISHOP.getValue());
    }
}
