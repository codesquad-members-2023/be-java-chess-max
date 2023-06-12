package chess.pieces.rook;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RookTest {

    @DisplayName("rook의 score는 5입니다.")
    @Test
    void getScore() {
        Rook r = new WhiteRook();
        assertThat(r.getScore()).isEqualTo(5);
        r = new BlackRook();
        assertThat(r.getScore()).isEqualTo(5);
    }


    @DisplayName("4개의 방향으로 이동할 수 있다.")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        BlackRook blackRook = new BlackRook();
        assertThat(blackRook.getCanMovePositions(Position.parse("a8"), board)).isEmpty();

        assertThat(blackRook.getCanMovePositions(Position.parse("a7"), board)).containsOnly(
                Position.parse("a6"),
                Position.parse("a5"),
                Position.parse("a4"),
                Position.parse("a3"),
                Position.parse("a2")
        );

        assertThat(blackRook.getCanMovePositions(Position.parse("b7"), board)).containsOnly(
                Position.parse("b6"),
                Position.parse("b5"),
                Position.parse("b4"),
                Position.parse("b3"),
                Position.parse("b2")
        );

        assertThat(blackRook.getCanMovePositions(Position.parse("d5"), board)).containsOnly(
                Position.parse("d6"),
                Position.parse("c5"),
                Position.parse("b5"),
                Position.parse("a5"),
                Position.parse("d4"),
                Position.parse("d3"),
                Position.parse("d2"),
                Position.parse("e5"),
                Position.parse("f5"),
                Position.parse("g5"),
                Position.parse("h5")
        );
    }
}
