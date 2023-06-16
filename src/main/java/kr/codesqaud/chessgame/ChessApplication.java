package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.controller.ConsoleChessGameController;
import kr.codesqaud.chessgame.view.ConsoleView;

public class ChessApplication {

    public static void main(String[] args) {
        final ConsoleChessGameController consoleChessGameController = new ConsoleChessGameController(new ConsoleView());
        consoleChessGameController.service(System.in);
    }
}
