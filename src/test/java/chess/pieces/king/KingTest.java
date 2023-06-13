package chess.pieces.king;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KingTest {

    @DisplayName("King의 score는 0점입니다")
    @Test
    void getScore() {
        King king = new WhiteKing();
        assertThat(king.getScore()).isEqualTo(0);
        king = new BlackKing();
        assertThat(king.getScore()).isEqualTo(0);
    }

    @DisplayName("King은 8개방향으로 한칸 이동 가능하다")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        King king = new BlackKing();
        assertThat(king.getCanMovePositions(Position.parse("a8"), board)).isEmpty();

        assertThat(king.getCanMovePositions(Position.parse("b7"), board)).containsOnly(
                Position.parse("a6"),
                Position.parse("c6"),
                Position.parse("b6")
        );
    }
}
