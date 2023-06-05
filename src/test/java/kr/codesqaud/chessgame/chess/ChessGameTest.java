package kr.codesqaud.chessgame.chess;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {

    @Test
    @DisplayName("start 명령어를 입려갛고 end 명령어를 입력하여 게임을 종료한다.")
    public void start() throws FileNotFoundException {
        // given
        FileInputStream in = new FileInputStream("src/test/resources/commands.txt");
        ChessGame chessGame = new ChessGame(in);
        // when
        chessGame.start();
        // then
    }
}
