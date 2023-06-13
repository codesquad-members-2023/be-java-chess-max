package chess.pieces.rook;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackRookTest {

    @DisplayName("인증 할 color가 Black 일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        BlackRook blackRook = new BlackRook();
        assertThat(blackRook.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackRook.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("PawnRepresentation.BLACK_ROOK 를 return")
    @Test
    void getRepresentation() {
        BlackRook blackRook = new BlackRook();

        assertThat(blackRook.getRepresentation()).isEqualTo(Representation.BLACK_ROOK.getValue());
    }
}
