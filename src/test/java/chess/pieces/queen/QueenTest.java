package chess.pieces.queen;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

    @DisplayName("queen의 score는 9입니다.")
    @Test
    void getScore() {
        Queen queen = new WhiteQueen();
        assertThat(queen.getScore()).isEqualTo(9);
        queen = new BlackQueen();
        assertThat(queen.getScore()).isEqualTo(9);
    }

    @DisplayName("8개의 방향으로 이동할 수 있다.")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        BlackQueen blackQueen = new BlackQueen();
        assertThat(blackQueen.getCanMovePositions(Position.parse("a8"), board)).isEmpty();

        assertThat(blackQueen.getCanMovePositions(Position.parse("a7"), board)).containsOnly(
                Position.parse("a6"),
                Position.parse("a5"),
                Position.parse("a4"),
                Position.parse("a3"),
                Position.parse("a2"),
                Position.parse("b6"),
                Position.parse("c5"),
                Position.parse("d4"),
                Position.parse("e3"),
                Position.parse("f2")
        );

        assertThat(blackQueen.getCanMovePositions(Position.parse("b7"), board)).containsOnly(
                Position.parse("b6"),
                Position.parse("b5"),
                Position.parse("b4"),
                Position.parse("b3"),
                Position.parse("b2"),
                Position.parse("a6"),
                Position.parse("c6"),
                Position.parse("d5"),
                Position.parse("e4"),
                Position.parse("f3"),
                Position.parse("g2")
        );

        assertThat(blackQueen.getCanMovePositions(Position.parse("d5"), board)).containsOnly(
                Position.parse("d6"),
                Position.parse("c6"),
                Position.parse("c5"),
                Position.parse("b5"),
                Position.parse("a5"),
                Position.parse("c4"),
                Position.parse("b3"),
                Position.parse("a2"),
                Position.parse("d4"),
                Position.parse("d3"),
                Position.parse("d2"),
                Position.parse("e4"),
                Position.parse("f3"),
                Position.parse("g2"),
                Position.parse("e5"),
                Position.parse("f5"),
                Position.parse("g5"),
                Position.parse("h5"),
                Position.parse("e6")
        );
    }
}
