package chess;

import chess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("create: Board에 Pawn을 추가하면 Pawn의 수가 증가한다")
    public void create() {
        Pawn whitePawn = new Pawn(WHITE);
        board.addWhitePawn(whitePawn);
        assertAll(() -> assertThat(board.size()).isEqualTo(1),
                  () -> assertThat(board.findWhitePawn(0)).isEqualTo(whitePawn));

        Pawn blackPawn = new Pawn(BLACK);
        board.addBlackPawn(blackPawn);
        assertAll(() -> assertThat(board.size()).isEqualTo(2),
                  () -> assertThat(board.findBlackPawn(0)).isEqualTo(blackPawn));
    }

    @Test
    @DisplayName("initialize: 체스판을 초기화한다")
    public void initialize() {
        board.initialize();

        assertThat(board.size()).isEqualTo(16);
    }

}
