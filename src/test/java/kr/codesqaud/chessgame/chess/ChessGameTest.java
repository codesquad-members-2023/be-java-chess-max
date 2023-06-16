package kr.codesqaud.chessgame.chess;

import kr.codesqaud.chessgame.chess.board.ChessBoard;
import kr.codesqaud.chessgame.exception.InvalidTurnException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessGameTest {

    @Test
    @DisplayName("백색인 선공인 상테에서 흑백 기물을 이동시키려고 할때 거부된다")
    public void givenWhitePlayerTurn_whenMoveBlackPiece_thenException() {
        // given
        ChessGame game = new ChessGame(new ChessBoard());
        game.initialize();
        // when
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThatThrownBy(() -> {
                game.move("a7", "a6");
            }).isInstanceOf(InvalidTurnException.class);
        });
    }

    @Test
    @DisplayName("백색이 선공인 상태에서 빈칸을 이동시키려고 할때 거부된다.")
    public void givenWhitePlayerTurn_whenMoveBlank_thenException() {
        // given
        ChessGame game = new ChessGame(new ChessBoard());
        game.initialize();
        // when
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThatThrownBy(() -> {
                game.move("a3", "a4");
            }).isInstanceOf(InvalidTurnException.class);
        });
    }
}
