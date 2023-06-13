package chess.pieces.bishop;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BishopTest {

    @DisplayName("Bishop의 score 는 3점입니다.")
    @Test
    void getScore() {
        Bishop bishop = new BlackBishop();
        assertThat(bishop.getScore()).isEqualTo(3);
        bishop = new WhiteBishop();
        assertThat(bishop.getScore()).isEqualTo(3);
    }

    @DisplayName("Bishop는 대각선으로만 이동 가능하다")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        Bishop bishop = new BlackBishop();
        assertThat(bishop.getCanMovePositions(Position.parse("a8"), board)).isEmpty();

        assertThat(bishop.getCanMovePositions(Position.parse("b7"), board)).containsOnly(
                Position.parse("a6"),
                Position.parse("c6")
        );
    }
}
