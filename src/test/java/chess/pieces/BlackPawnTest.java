package chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackPawnTest {

    @DisplayName("생삭이 Black일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        BlackPawn blackPawn = new BlackPawn();
        assertThat(blackPawn.verifyPawn(Color.BLACK)).isTrue();
        assertThat(blackPawn.verifyPawn(Color.WHITE)).isFalse();
    }

    @DisplayName("PawnRepresentation.Black 를 return")
    @Test
    void getRepresentation() {
        BlackPawn blackPawn = new BlackPawn();

        assertThat(blackPawn.getRepresentation()).isEqualTo(PawnRepresentation.BLACK);
    }
}
