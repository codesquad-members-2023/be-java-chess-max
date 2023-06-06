package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.PieceColor.*;

class PawnTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create() {
        validatePawn(WHITE_COLOR, WHITE_REPRESENTATION);
        validatePawn(BLACK_COLOR, BLACK_REPRESENTATION);
    }

    private void validatePawn(final String color, final char representation) {
        final Pawn pawn = new Pawn(color, representation);
        assertThat(color).isEqualTo(pawn.getColor());
        assertThat(representation).isEqualTo(pawn.getRepresentation());
    }

    @DisplayName("색이 없는 폰을 생성하는 경우 흰색 말을 생성한다")
    @Test
    void create_기본생성자() {
        final Pawn pawn = new Pawn();
        assertThat(WHITE_COLOR).isEqualTo(pawn.getColor());
        assertThat(WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }
}