package kr.codesqaud.chess.pieces;


import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Pawn;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("기본 생성자로 만든 폰이 흰색이어야 한다")
    public void create_NoArgsConstructor() {
        Pawn pawn = new Pawn();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
        assertions.assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

    private void verifyPawn(final kr.codesqaud.chessgame.pieces.Color color, final String representation) {
        SoftAssertions assertions = new SoftAssertions();
        Pawn pawn = new Pawn(color, representation);
        assertions.assertThat(pawn.getRepresentation()).isEqualTo(color);
        assertions.assertThat(pawn.getColor()).isEqualTo(representation);
    }
}
