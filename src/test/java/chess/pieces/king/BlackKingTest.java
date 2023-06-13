package chess.pieces.king;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackKingTest {

    @DisplayName("인증 할 color가 Black면 true 아니면 false")
    @Test
    void verifyColor() {
        BlackKing blackKing = new BlackKing();
        assertThat(blackKing.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackKing.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("representation.BLACK_KING 반환 한다.")
    @Test
    void getRepresentation() {
        BlackKing blackKing = new BlackKing();

        assertThat(blackKing.getRepresentation()).isEqualTo(Representation.BLACK_KING.getValue());
    }
}
