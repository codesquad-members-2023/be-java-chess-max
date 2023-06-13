package kr.codesqaud.chessgame.chess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessGameTest {

    @Test
    @DisplayName("start 명령어를 입려갛고 end 명령어를 입력하여 게임을 종료한다.")
    public void start() throws FileNotFoundException {
        // given
        FileInputStream in = new FileInputStream("src/test/resources/commands.txt");
        ChessGame chessGame = new ChessGame();
        // when
        chessGame.run(in);
        // then
    }
}
