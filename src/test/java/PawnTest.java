import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성된다")
    void createPawns() {
        String white = "white";
        String black = "black";

        verifyPawnColor(white);
        verifyPawnColor(black);
    }

    public void verifyPawnColor(final String color) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
