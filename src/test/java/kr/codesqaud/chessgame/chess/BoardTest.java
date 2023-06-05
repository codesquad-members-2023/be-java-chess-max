package kr.codesqaud.chessgame.chess;

import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Pawn;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class BoardTest {
    private static final Logger logger = LoggerFactory.getLogger(BoardTest.class);


    @Test
    @DisplayName("Board 객체가 생성되고 Pawn 객체를 추가할 수 있어야 한다")
    public void create() {
        Board board = new Board();
        Pawn white = new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        Pawn black = new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);

        board.add(white);
        verifyBoardSize(board, 1);
        verifyFindPawn(board, 0, white);

        board.add(black);
        verifyBoardSize(board, 2);
        verifyFindPawn(board, 1, black);
    }

    private void verifyBoardSize(final Board board, final int expectedSize) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.size()).isEqualTo(expectedSize);
    }

    private void verifyFindPawn(final Board board, final int index, final Pawn expectedPawn) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.findPawn(index)).isEqualTo(expectedPawn);
    }

    @Test
    @DisplayName("initialize 메소드를 실행하면 흰색 Pawn과 검은색 Pawn을 생성하여 Board 객체의 리스트에 저장한다")
    public void initialize() {
        // given
        Board board = new Board();
        // when
        board.initialize();
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertions.assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("print 메소드를 실행하면 체스판 문자열이 반한된다")
    public void print() throws IOException {
        // given
        Board board = new Board();
        board.initialize();
        // when
        String chessBoard = board.print();
        logger.debug("checssBoard \n{}", chessBoard);
        // then
        String expectedChessBoard = Files.readString(Paths.get("src/test/resources/chessBoard.txt"));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(chessBoard).isEqualTo(expectedChessBoard);
        assertions.assertAll();
    }
}
