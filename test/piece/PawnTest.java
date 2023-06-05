package piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static piece.Color.BLACK;
import static piece.Color.WHITE;

class PawnTest {

    @Test
    @DisplayName("create: 흰색 폰과 검은색 폰을 생성한다")
    public void create() {
        assertAll(() -> verifyPawn(WHITE),
                  () -> verifyPawn(BLACK));
    }

    void verifyPawn(final Color color) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color);
    }

}
