package chess.pieces.rook;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhiteRookTest {

    @DisplayName("인증 할 color가 Black 일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        WhiteRook whiteRook = new WhiteRook();
        assertThat(whiteRook.verifyColor(Color.WHITE)).isTrue();
        assertThat(whiteRook.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("PawnRepresentation.BLACK_ROOK 를 return")
    @Test
    void getRepresentation() {
        WhiteRook whiteRook = new WhiteRook();

        assertThat(whiteRook.getRepresentation()).isEqualTo(Representation.WHITE_ROOK);
    }
}
