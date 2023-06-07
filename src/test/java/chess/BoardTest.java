package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    @DisplayName("체스판을 생성해서 폰을 추가하고 폰의 개수를 확인하고 추가한 폰이 맞는지 확인한다.")
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("검은색 폰 8개와 흰색 폰 8개가 생성된다.")
    public void initialize() {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnResult());
        assertEquals("PPPPPPPP", board.getBlackPawnResult());
    }
}
