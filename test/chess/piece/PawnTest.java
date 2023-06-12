package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 흰색 폰이 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositionsOfWhite() {
        Pawn white = Pawn.createWhite(new Position("a1"));
        assertThat(white.getValidMovePositions()).containsExactlyInAnyOrder(new Position("a2"), new Position("b2"));

        white.setPosition(new Position("b1"));
        assertThat(white.getValidMovePositions()).containsExactlyInAnyOrder(new Position("a2"), new Position("b2"), new Position("c2"));

        white.setPosition(new Position("a8"));
        assertThat(white.getValidMovePositions()).isEmpty();
    }

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 검은색 폰이 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositionsOfBlack() {
        Pawn black = Pawn.createBlack(new Position("a1"));
        assertThat(black.getValidMovePositions()).isEmpty();

        black.setPosition(new Position("g7"));
        assertThat(black.getValidMovePositions()).containsExactlyInAnyOrder(new Position("f6"), new Position("g6"), new Position("h6"));

        black.setPosition(new Position("h8"));
        assertThat(black.getValidMovePositions()).containsExactlyInAnyOrder(new Position("g7"), new Position("h7"));
    }

}
