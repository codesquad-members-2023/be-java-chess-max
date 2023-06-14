package chess;

import chess.exception.InvalidTurnException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ChessGameTest {

    ChessGame chessGame;

    @BeforeEach
    void setUp() {
        chessGame = new ChessGame();
    }

    @Test
    @DisplayName("게임의 첫 턴에 검은색 말을 옮기면 에러가 발생한다")
    public void startAtBlack() {
        chessGame.setUp();

        assertThatThrownBy(() -> chessGame.move("a7", "a6"))
                .isInstanceOf(InvalidTurnException.class)
                .hasMessageContaining("해당 색상의 말을 옮길 차례가 아닙니다.");
    }

    @Test
    @DisplayName("게임의 첫 턴은 흰색으로 시작한다")
    public void startAtWhite() {
        chessGame.setUp();

        assertThatCode(() -> chessGame.move("a2", "a3")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("흰색과 검은색이 번갈아가며 말을 이동한다")
    public void checkTurnBeforeMove() {
        chessGame.setUp();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatCode(() -> chessGame.move("a2", "a3")).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> chessGame.move("a7", "a6")).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> chessGame.move("b2", "b3")).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> chessGame.move("b7", "b6")).doesNotThrowAnyException();

        softAssertions.assertAll();
    }

}
