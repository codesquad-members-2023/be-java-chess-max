package chess.pieces;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static chess.pieces.PawnRepresentation.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @DisplayName("화이트 폰이 생성되어야 한다")
    @Test
    public void createWhitePawn() {
        Pawn pawn = new Pawn(WHITE);

        assertThat(pawn.verifyPawn(WHITE)).isTrue();
    }

    @DisplayName("블랙 폰이 생성되어야 한다")
    @Test
    public void createBlackPawn() {
        Pawn pawn = new Pawn(BLACK);

        assertThat(pawn.verifyPawn(BLACK)).isTrue();
    }

    @DisplayName("화이트 폰이면 p 출력한다")
    @Test
    public void printWhitePawn() {
        Pawn pawn = new Pawn(WHITE);

        assertThat(pawn.getRepresentation()).isEqualTo(p);
    }

    @DisplayName("블랙 폰이면 P 출력한다")
    @Test
    public void printBlackPawn() {
        Pawn pawn = new Pawn(BLACK);

        assertThat(pawn.getRepresentation()).isEqualTo(P);
    }
}
