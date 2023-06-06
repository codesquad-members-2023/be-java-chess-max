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
    @DisplayName("add(): 임의의 말이 pieces에 추가된다.")
    void addPiece() {
        Piece piece = Piece.createBlackKnight();

        board.add(piece);

        assertThat(board.contains(piece)).isTrue();
        assertThat(board.getSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("add(): 임의의 말이 연속적으로 pieces에 추가된다.")
    void addPieces() {
        Piece one = Piece.createBlackBishop();
        Piece two = Piece.createWhiteQueen();
        Piece three = Piece.createWhiteRook();

        board.add(one);
        assertThat(board.getSize()).isEqualTo(1);
        board.add(two);
        assertThat(board.getSize()).isEqualTo(2);
        board.add(three);
        assertThat(board.getSize()).isEqualTo(3);

        assertThat(board.contains(one)).isTrue();
        assertThat(board.contains(two)).isTrue();
        assertThat(board.contains(three)).isTrue();
    }

    @Test
    @DisplayName("initialize(): 32개의 말들로 초기화된다")
    public void initializeBoard() {
        board.initialize();

        assertThat(board.getSize()).isEqualTo(32);
    }

    @Test
    @DisplayName("initialize(): 여러번 초기화해도 중첩되지 않는다")
    public void initializeMultipleTimes() {
        String figure = appendNewLine("RNBQKBNR") +
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

        assertThat(board.getSize()).isEqualTo(32);
        assertThat(board.print()).isEqualTo(figure);
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
}
