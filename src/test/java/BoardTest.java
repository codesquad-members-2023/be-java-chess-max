import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드가 생성되는지 확인")
    void createBoard() {
        assertThat(board).isInstanceOf(Board.class);
    }

    @Test
    @DisplayName("하얀색 폰이 추가되는지 확인")
    void addWhitePawn() {
        Pawn pawn = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_FIGURE);

        board.add(pawn);

        assertThat(board.contains(pawn)).isTrue();
        assertThat(board.getSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("검은색 폰이 추가되는지 확인")
    void addBlackPawn() {
        Pawn pawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_FIGURE);

        board.add(pawn);

        assertThat(board.contains(pawn)).isTrue();
        assertThat(board.getSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("여러 개의 폰이 추가되는지 확인")
    void addPawns() {
        Pawn one = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_FIGURE);
        Pawn two = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_FIGURE);
        Pawn three = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_FIGURE);
        Pawn four = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_FIGURE);

        board.add(one);
        assertThat(board.getSize()).isEqualTo(1);
        board.add(two);
        assertThat(board.getSize()).isEqualTo(2);
        board.add(three);
        assertThat(board.getSize()).isEqualTo(3);
        board.add(four);
        assertThat(board.getSize()).isEqualTo(4);

        assertThat(board.contains(one)).isTrue();
        assertThat(board.contains(two)).isTrue();
        assertThat(board.contains(three)).isTrue();
        assertThat(board.contains(four)).isTrue();
    }

    @Test
    @DisplayName("initialize()을 호출하면 16개의 폰이 추가된다")
    public void initializeAdd16Pawns() {
        board.initialize();

        assertThat(board.getSize()).isEqualTo(16);
    }

    @Test
    @DisplayName("initialize()를 호출하면 8개의 검정색 폰이 추가된다")
    public void initializeAdd8BlackPawns() {
        String figure = "PPPPPPPP" + System.lineSeparator();

        board.initialize();

        assertThat(board.printBlackPawns()).isEqualTo(figure);
    }

    @Test
    @DisplayName("initialize()를 호출하면 8개의 하얀색 폰이 추가된다")
    public void initializeAdd8WhitePawns() {
        String figure = "pppppppp" + System.lineSeparator();

        board.initialize();

        assertThat(board.printWhitePawns()).isEqualTo(figure);
    }

    @Test
    @DisplayName("initialize()를 호출하고 화면을 출력한다")
    public void initializeThenPrintBoard() {
        String figure = "........" + System.lineSeparator() +
                "PPPPPPPP" + System.lineSeparator()+
                "........" + System.lineSeparator()+
                "........" + System.lineSeparator()+
                "........" + System.lineSeparator()+
                "........" + System.lineSeparator()+
                "pppppppp" + System.lineSeparator()+
                "........"+ System.lineSeparator();

        board.initialize();

        assertThat(board.print()).isEqualTo(figure);
    }


}
