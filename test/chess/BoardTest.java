package chess;

import chess.piece.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    @Test
    @DisplayName("create: Board에 Pawn을 추가하면 Pawn의 수가 증가한다")
    public void create() {
        Board board = new Board();

        assertAll(() -> createPawn(board, WHITE),
                  () -> createPawn(board, BLACK));
    }

    void createPawn(final Board board, final Color color) {
        int pawnCount = board.countPawn();
        Pawn pawn = new Pawn(color);
        board.add(pawn);

        assertThat(board.countPawn()).isEqualTo(pawnCount + 1);
        assertThat(board.findPawn(pawnCount)).isEqualTo(pawn);
    }

}
