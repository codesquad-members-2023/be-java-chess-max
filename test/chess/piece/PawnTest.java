package chess.piece;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {

    @Test
    @DisplayName("create: 흰색 폰과 검은색 폰을 생성한다")
    public void create() {
        assertAll(() -> verifyPawnColor(WHITE),
                  () -> verifyPawnColor(BLACK));
    }

    void verifyPawnColor(final Color color) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("create: 기본 생성자로 생성 시 흰색 폰을 생성한다")
    public void createDefault() {
        Pawn pawn = new Pawn();

        assertThat(pawn.getColor()).isEqualTo(WHITE);
    }

    @Test
    @DisplayName("getPresentation: 흰색 폰은 소문자 p, 검은색 폰은 대문자 P로 표현한다")
    public void getPresentation() {
        assertAll(() -> verifyPawnRepresentation(WHITE, Pawn.WHITE_REPRESENTATION),
                  () -> verifyPawnRepresentation(BLACK, Pawn.BLACK_REPRESENTATION));
    }

    void verifyPawnRepresentation(final Color color, final String representation) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

}
