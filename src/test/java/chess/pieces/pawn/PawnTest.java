package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @DisplayName("pawn의 score는 1입니다.")
    @Test
    void getScore() {
        Pawn pawn = new WhitePawn();
        assertThat(pawn.getScore()).isEqualTo(1);
        pawn = new BlackPawn();
        assertThat(pawn.getScore()).isEqualTo(1);
    }
}
