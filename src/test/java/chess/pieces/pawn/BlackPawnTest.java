package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackPawnTest {

    @DisplayName("생삭이 Black일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        BlackPawn blackPawn = new BlackPawn();
        assertThat(blackPawn.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackPawn.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("PawnRepresentation.Black 를 return")
    @Test
    void getRepresentation() {
        BlackPawn blackPawn = new BlackPawn();

        assertThat(blackPawn.getRepresentation()).isEqualTo(Representation.BLACK_PAWN);
    }
}
