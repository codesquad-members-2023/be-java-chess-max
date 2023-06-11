package chess.pieces.queen;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackQueenTest {

    @DisplayName("인증 할 color가 Black일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        BlackQueen blackQueen = new BlackQueen();
        assertThat(blackQueen.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackQueen.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("PawnRepresentation.BLACK_QUEEN 를 return")
    @Test
    void getRepresentation() {
        BlackQueen blackQueen = new BlackQueen();
        assertThat(blackQueen.getRepresentation()).isEqualTo(Representation.BLACK_QUEEN.getValue());
    }

}
