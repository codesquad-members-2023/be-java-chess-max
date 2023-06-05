import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성된다")
    void createPawns() {
        String white = "white";
        String black = "black";
        Pawn onePawn = new Pawn(white);
        Pawn otherPawn = new Pawn(black);

        assertThat(onePawn.getColor()).isEqualTo(white);
        assertThat(otherPawn.getColor()).isEqualTo(black);
    }
}
