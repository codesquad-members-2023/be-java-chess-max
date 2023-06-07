package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Board.BLANK_LINE;
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
    @DisplayName("initialize: 체스판 초기화 시 총 32개의 기물을 생성한다")
    public void initialize() {
        board.initialize();

        String blackPieces = "RNBQKBNR" + NEW_LINE;
        String blackPawns = "PPPPPPPP" + NEW_LINE;
        String whitePawns = "pppppppp" + NEW_LINE;
        String whitePieces = "rnbqkbnr" + NEW_LINE;
        String blankLine = BLANK_LINE + NEW_LINE;

        assertAll(() -> assertThat(board.countPieces()).isEqualTo(32),
                  () -> assertThat(board.show()).isEqualTo(
                          blackPieces + blackPawns +
                                  blankLine + blankLine + blankLine + blankLine +
                                  whitePawns + whitePieces));
    }

}
