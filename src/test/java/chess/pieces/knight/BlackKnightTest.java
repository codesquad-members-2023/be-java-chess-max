package chess.pieces.knight;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackKnightTest {

    @DisplayName("인증 할 color가 Black면 true 아니면 false")
    @Test
    void verifyColor() {
        BlackKnight blackKnight = new BlackKnight();
        assertThat(blackKnight.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackKnight.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("representation.BLACK_KNIGHT 반환 한다.")
    @Test
    void getRepresentation() {
        BlackKnight blackKnight = new BlackKnight();

        assertThat(blackKnight.getRepresentation()).isEqualTo(Representation.BLACK_KNIGHT);
    }
}
