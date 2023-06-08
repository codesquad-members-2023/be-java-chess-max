package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판을 초기 기물 위치에 맞게 초기화한다.")
    public void create() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);

        String blankLine = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") +
                        blankLine + blankLine + blankLine + blankLine +
                        appendNewLine("pppppppp") + appendNewLine("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("검은색 폰 8개와 흰색 폰 8개가 생성된다.")
    public void initialize() {
        Board board = new Board();
        board.initialize();

        System.out.println(board.showBoard());
    }
}
