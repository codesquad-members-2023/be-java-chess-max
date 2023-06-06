import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성된다")
    void createWhitePawn() {
        Pawn pawn = new Pawn(Pawn.COLOR_WHITE, Pawn.WHITE_FIGURE);

        assertThat(pawn.getColor()).isEqualTo(Pawn.COLOR_WHITE);
        assertThat(pawn.getFigure()).isEqualTo(Pawn.WHITE_FIGURE);
    }

    @Test
    @DisplayName("검정색 폰이 생성된다")
    void createBlackPawn() {
        Pawn pawn = new Pawn(Pawn.COLOR_BLACK, Pawn.BLACK_FIGURE);

        assertThat(pawn.getColor()).isEqualTo(Pawn.COLOR_BLACK);
        assertThat(pawn.getFigure()).isEqualTo(Pawn.BLACK_FIGURE);
    }

    @Test
    @DisplayName("기본 생성자로 폰을 만들면 하얀색 폰이 생성된다")
    void createPawnUsingDefaultConstructor() {
        Pawn pawn = new Pawn();

        assertThat(pawn.getColor()).isEqualTo(Pawn.COLOR_WHITE);
        assertThat(pawn.getFigure()).isEqualTo(Pawn.WHITE_FIGURE);
    }
}
