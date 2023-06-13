package chess.pieces.queen;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhiteQueenTest {

    @DisplayName("인증 할 color가 White 일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        WhiteQueen whiteQueen = new WhiteQueen();
        assertThat(whiteQueen.verifyColor(Color.WHITE)).isTrue();
        assertThat(whiteQueen.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("PawnRepresentation.WHITE_QUEEN 를 return")
    @Test
    void getRepresentation() {
        WhiteQueen whiteQueen = new WhiteQueen();

        assertThat(whiteQueen.getRepresentation()).isEqualTo(Representation.WHITE_QUEEN.getValue());
    }

}
