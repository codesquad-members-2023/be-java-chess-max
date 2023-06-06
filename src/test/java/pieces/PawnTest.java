package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PawnTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create() {
        final Pawn pawn1 = new Pawn("white");
        final Pawn pawn2 = new Pawn("black");

        assertAll(() -> assertThat(pawn1.getColor()).isEqualTo("white"),
                () -> assertThat(pawn2.getColor()).isEqualTo("black"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> assertThat(new Pawn("orange"))));
    }
}