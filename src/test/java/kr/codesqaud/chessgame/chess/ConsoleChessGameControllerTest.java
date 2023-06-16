package kr.codesqaud.chessgame.chess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kr.codesqaud.chessgame.controller.ConsoleChessGameController;
import kr.codesqaud.chessgame.view.ConsoleView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleChessGameControllerTest {

    @Test
    @DisplayName("start 명령어를 입려갛고 end 명령어를 입력하여 게임을 종료한다.")
    public void start() throws FileNotFoundException {
        // given
        FileInputStream in = new FileInputStream("src/test/resources/commands.txt");
        ConsoleChessGameController consoleChessGameController = new ConsoleChessGameController(new ConsoleView());
        // when
        consoleChessGameController.service(in);
        // then
    }

    @Test
    @DisplayName("checkmate.txt 파일 입력대로 수행하여 백색 체크메이트 된다")
    public void checkmate() throws FileNotFoundException {
        // given
        FileInputStream in = new FileInputStream("src/test/resources/checkmate.txt");
        ConsoleChessGameController consoleChessGameController = new ConsoleChessGameController(new ConsoleView());
        // when
        consoleChessGameController.service(in);
        // then
    }
}
