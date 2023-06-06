package chess;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    @DisplayName("보드에 기물이 추가한다")
    @Test
    void addPiece() {
        Board board = new Board();
        Pawn white = new Pawn(WHITE);
        Pawn black = new Pawn(BLACK);


        board.add(white);
        assertThat(board.size()).isEqualTo(1);


        board.add(black);
        assertThat(board.size()).isEqualTo(2);
    }
}
