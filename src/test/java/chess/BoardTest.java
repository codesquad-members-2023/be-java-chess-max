package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @DisplayName("initialize: 체스 판을 p와 P로 구분하여 초기화한다.")
    @Test
    void initialize() throws Exception {
        final Board board = new Board();
        board.initialize();

        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }

    @DisplayName("전체 체스판의 전체 상태를 알 수 있다.")
    @Test
    void create() throws Exception {
        board.initialize();

        assertThat(32).isEqualTo(board.pieceCount());

        String blankRank = appendNewLine("........");

        assertThat(board.createChessBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }
}