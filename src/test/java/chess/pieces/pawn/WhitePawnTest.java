package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhitePawnTest {

    @DisplayName("생삭이 화이트일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        WhitePawn whitePawn = new WhitePawn();
        assertThat(whitePawn.verifyColor(Color.WHITE)).isTrue();
        assertThat(whitePawn.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("PawnRepresentation.WHITE 를 return")
    @Test
    void getRepresentation() {
        WhitePawn whitePawn = new WhitePawn();

        assertThat(whitePawn.getRepresentation()).isEqualTo(Representation.WHITE_PAWN);
    }
}
