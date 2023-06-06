package kr.codesqaud.chessgame.chess;

import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Piece;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("board가 initialize 메소드를 호출했을때 체스판의 기물들을 초기화한다")
    public void create() throws IOException {
        // given
        // when
        board.initialize();
        // then
        String expectedBoard = Files.readString(Paths.get("src/test/resources/chessBoard.txt"));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.size()).isEqualTo(32);
        assertions.assertThat(board.showBoard()).isEqualTo(expectedBoard);
        assertions.assertAll();
    }
}
