package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.*;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.Piece.Color;
import static pieces.Piece.Type;
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

    @Test
    @DisplayName("특정 색깔과 종류 기물의 개수를 반환한다.")
    public void pieceCount() {
        board.initialize();

        assertThat(board.pieceCount(Color.BLACK, Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Color.BLACK, Type.BISHOP)).isEqualTo(2);
        assertThat(board.pieceCount(Color.BLACK, Type.QUEEN)).isEqualTo(1);

        assertThat(board.pieceCount(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Color.WHITE, Type.ROOK)).isEqualTo(2);
        assertThat(board.pieceCount(Color.WHITE, Type.KING)).isEqualTo(1);
    }

    @Test
    @DisplayName("입력한 위치에 해당하는 기물을 반환한다.")
    public void findPiece() throws Exception {
        //given
        board.initialize();
        //when
        Piece a8 = board.findPiece(new Position("a8"));
        Piece c7 = board.findPiece(new Position("c7"));
        Piece a1 = board.findPiece(new Position("a1"));
        Piece d2 = board.findPiece(new Position("d2"));
        //then
        Assertions.assertEquals(a8, Rook.createBlack(new Position("a8")));
        Assertions.assertEquals(c7, Pawn.createBlack(new Position("c7")));
        Assertions.assertEquals(a1, Rook.createWhite(new Position("a1")));
        Assertions.assertEquals(d2, Pawn.createWhite(new Position("d2")));
    }

    @Test
    @DisplayName("입력한 위치에 기물을 추가한다.")
    public void move() throws Exception {
        //given
        board.initializeEmpty();

        Piece piece = Rook.createBlack(new Position("b8"));
        Position position = new Position("b5");

        //when
        board.move(position, piece);

        //then
        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("같은 색깔의 남아있는 기물들 점수의 합을 계산한다.")
    public void calculatePoint() throws Exception {
        //given
        board.initializeEmpty();
        //when
        addPiece("b6", Pawn.createBlack(new Position("b6")));
        addPiece("e6", Queen.createBlack(new Position("e6")));
        addPiece("b8", King.createBlack(new Position("b8")));
        addPiece("c8", Rook.createBlack(new Position("c8")));

        addPiece("f4", Pawn.createWhite(new Position("f4")));
        addPiece("f3", Pawn.createWhite(new Position("f3")));
        addPiece("f2", Pawn.createWhite(new Position("f2")));
        addPiece("g2", Pawn.createWhite(new Position("g2")));
        addPiece("e1", Rook.createWhite(new Position("e1")));
        addPiece("f1", King.createWhite(new Position("f1")));

        //then
        Assertions.assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        Assertions.assertEquals(7.5, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(new Position(position), piece);
    }
}
