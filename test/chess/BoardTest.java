package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.StringUtil.NEW_LINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("initialize: 체스판의 모든 칸을 Piece로 초기화한다")
    public void initialize() {
        board.initialize();

        String blankLine = "........" + NEW_LINE;
        String blackPieces = "RNBQKBNR" + NEW_LINE;
        String blackPawns = "PPPPPPPP" + NEW_LINE;
        String whitePawns = "pppppppp" + NEW_LINE;
        String whitePieces = "rnbqkbnr";

        assertAll(() -> assertThat(board.countPieces()).isEqualTo(32),
                  () -> assertThat(board.show()).isEqualTo(
                          blackPieces + blackPawns +
                                  blankLine + blankLine + blankLine + blankLine +
                                  whitePawns + whitePieces));
    }

}
