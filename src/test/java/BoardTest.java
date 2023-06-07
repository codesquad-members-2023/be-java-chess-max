import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtil.appendNewLine;

class BoardTest {

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("Board(): 보드가 생성되는지 확인")
    void createBoard() {
        assertThat(board).isInstanceOf(Board.class);
    }

    @Test
    @DisplayName("initialize(): 8개의 rank로 초기화된다")
    public void initializeBoard() {
        board.initialize();

        assertThat(board.getSize()).isEqualTo(8);
    }

    @Test
    @DisplayName("print(): 를 호출하고 화면을 출력한다")
    public void initializeThenPrintBoard() {
        String figure = appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");

        board.initialize();

        assertThat(board.print()).isEqualTo(figure);
    }

    @Test
    @DisplayName("initialize(): 여러번 초기화해도 중첩되지 않는다")
    public void initializeMultipleTimes() {
        String shape = appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");

        board .initialize();
        board .initialize();
        board .initialize();
        board .initialize();
        board .initialize();
        board .initialize();

        assertThat(board.getSize()).isEqualTo(8);
        assertThat(board.print()).isEqualTo(shape);
    }
}
