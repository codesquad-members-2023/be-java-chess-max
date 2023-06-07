package chess;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    @DisplayName("Board 초기화 출력")
    @Test
    void initAndPrint() {
        Board board = new Board();
        assertThat(board.print()).isEqualTo(
                """
                        RNBQKBNR  8 (rank 8)
                        PPPPPPPP  7
                        ........  6
                        ........  5
                        ........  4
                        ........  3
                        pppppppp  2
                        rnbqkbnr  1 (rank 1)

                        abcdefgh"""
        );
    }

}
