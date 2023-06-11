package chess.pieces.knight;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhiteKnightTest {

    @DisplayName("인증 할 인증 할 color가 White면 true 아니면 false")
    @Test
    void verifyColor() {
        WhiteKnight whiteKnight = new WhiteKnight();
        assertThat(whiteKnight.verifyColor(Color.WHITE)).isTrue();
        assertThat(whiteKnight.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("representation.BLACK_KNIGHT 반환 한다.")
    @Test
    void getRepresentation() {
        WhiteKnight whiteKnight = new WhiteKnight();

        assertThat(whiteKnight.getRepresentation()).isEqualTo(Representation.WHITE_KNIGHT.getValue());
    }
}
