package chess.pieces.knight;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KnightTest {

    @DisplayName("knight의 score는 2.5입니다.")
    @Test
    void getScore() {
        Knight knight = new WhiteKnight();
        assertThat(knight.getScore()).isEqualTo(2.5);
        knight = new BlackKnight();
        assertThat(knight.getScore()).isEqualTo(2.5);
    }

    @DisplayName("knight의 L자로만 이동 가능하다")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        Knight knight = new BlackKnight();
        assertThat(knight.getCanMovePositions(Position.parse("a8"), board)).containsOnly(
                Position.parse("b6")
        );

        assertThat(knight.getCanMovePositions(Position.parse("b7"), board)).containsOnly(
                Position.parse("a5"),
                Position.parse("c5"),
                Position.parse("d6")
        );
    }
}
