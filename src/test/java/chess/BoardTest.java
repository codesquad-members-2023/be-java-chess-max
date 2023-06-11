package chess;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.pawn.BlackPawn;
import chess.pieces.pawn.WhitePawn;
import chess.pieces.queen.WhiteQueen;
import chess.pieces.rook.BlackRook;
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

    @DisplayName("주어진 위치의 기물을 조회")
    @Test
    void findPiece() {
        Board board = new Board();
        assertThat(board.findPiece("a8")).containsInstanceOf(BlackRook.class);
        assertThat(board.findPiece("c7")).containsInstanceOf(BlackPawn.class);
        assertThat(board.findPiece("c4")).isEmpty();
        assertThat(board.findPiece("c2")).containsInstanceOf(WhitePawn.class);
        assertThat(board.findPiece("d1")).containsInstanceOf(WhiteQueen.class);

    }
}
