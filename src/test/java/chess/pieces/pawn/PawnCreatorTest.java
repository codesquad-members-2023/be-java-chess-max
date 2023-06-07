package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnCreatorTest {

    @DisplayName("색상에 따라 Pawn를 생성한다")
    @Test
    void create() {
        Pawn whitePawn = PawnCreator.create(Color.WHITE);
        Pawn blackPawn = PawnCreator.create(Color.BLACK);

        assertThat(whitePawn.getClass()).isEqualTo(WhitePawn.class);
        assertThat(blackPawn.getClass()).isEqualTo(BlackPawn.class);
    }
}
