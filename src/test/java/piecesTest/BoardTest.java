package piecesTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Board;
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
    @DisplayName("pieces.Board(): 보드가 생성되는지 확인")
    void createBoard() {
        assertThat(board).isInstanceOf(Board.class);
    }

    @Test
    @DisplayName("initializeDefaultBoard(): 기본배열로 초기화한다.")
    public void initializeDefaultBoard() {
        String shape = appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");

        board.initializeDefaultBoard();

        assertThat(board.getSize()).isEqualTo(8);
        assertThat(board.print()).isEqualTo(shape);
    }

    @Test
    @DisplayName("initializeDefaultBoard(): 여러번 초기화해도 중첩되지 않는다")
    public void initializeDefaultBoardMultipleTimes() {
        String shape = appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");

        board .initializeDefaultBoard();
        board .initializeDefaultBoard();
        board .initializeDefaultBoard();
        board .initializeDefaultBoard();
        board .initializeDefaultBoard();
        board .initializeDefaultBoard();

        assertThat(board.getSize()).isEqualTo(8);
        assertThat(board.print()).isEqualTo(shape);
    }

    @Test
    @DisplayName("initializeVoidBoard(): blank만으로 이루어진 board로 초기화한다")
    public void initializeThenPrintBoard() {
        String shape = appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........");

        board.initializeVoidBoard();

        assertThat(board.getSize()).isEqualTo(8);
        assertThat(board.print()).isEqualTo(shape);
    }

    @Test
    @DisplayName("initializeVoidBoard(): 여러번 초기화해도 중첩되지 않는다")
    public void initializeVoidBoardMultipleTimes() {
        String shape = appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........");

        board.initializeVoidBoard();
        board.initializeVoidBoard();
        board.initializeVoidBoard();
        board.initializeVoidBoard();
        board.initializeVoidBoard();

        assertThat(board.getSize()).isEqualTo(8);
        assertThat(board.print()).isEqualTo(shape);
    }

    @Test
    @DisplayName("insert(): 특정 위치에 새로운 Piece를 삽입한다")
    public void insertAtBoard() {
        board.initializeVoidBoard();
        Piece piece = Piece.createBlackQueen();

        board.insert(piece, "a1");

        assertThat(board.getPieceAt("a1")).isEqualTo(piece);
    }

    @Test
    @DisplayName("getPieceAt(): 특정 위치의 Piece를 가져온다")
    public void getPieceAtBoard() {
        board.initializeDefaultBoard();

        Piece piece = board.getPieceAt("c8");

        assertThat(piece.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(piece.isType(Piece.Type.BISHOP)).isTrue();
    }

    @Test
    @DisplayName("calculateScoreOf(): 기물의 점수를 계산한다")
    public void calculateScoreOfBoard() {
        board.initializeDefaultBoard();

        double blackScore = board.calculateScoreOf(Piece.Color.BLACK);
        double whiteScore = board.calculateScoreOf(Piece.Color.WHITE);

        assertThat(blackScore).isEqualTo(38);
        assertThat(whiteScore).isEqualTo(38);
    }

    @Test
    @DisplayName("calculateScoreOf(): 한 줄로 세워진 폰의 점수를 계산한다")
    public void calculateScoreOfSortedPawns() {
        board.initializeVoidBoard();
        board.insert(Piece.createBlackPawn(), "a8");
        board.insert(Piece.createBlackPawn(), "a7");
        board.insert(Piece.createBlackPawn(), "a6");
        board.insert(Piece.createBlackPawn(), "a5");
        board.insert(Piece.createBlackPawn(), "a4");
        board.insert(Piece.createBlackPawn(), "a3");
        board.insert(Piece.createBlackPawn(), "b3");
        board.insert(Piece.createBlackPawn(), "b4");
        board.insert(Piece.createBlackPawn(), "c3");
        board.insert(Piece.createBlackPawn(), "g3");


        double blackScore = board.calculateScoreOf(Piece.Color.BLACK);

        assertThat(blackScore).isEqualTo(4);
    }

}
