package chess.pieces.king;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhiteKingTest {

    @DisplayName("인증 할 color가 White면 true 아니면 false")
    @Test
    void verifyColor() {
        WhiteKing whiteKing = new WhiteKing();
        assertThat(whiteKing.verifyColor(Color.WHITE)).isTrue();
        assertThat(whiteKing.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("representation.WHITE_KING 반환 한다.")
    @Test
    void getRepresentation() {
        WhiteKing whiteKing = new WhiteKing();

        assertThat(whiteKing.getRepresentation()).isEqualTo(Representation.WHITE_KING);
    }
}
