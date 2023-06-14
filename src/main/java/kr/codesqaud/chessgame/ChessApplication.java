package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.controller.ChessGameController;
import kr.codesqaud.chessgame.view.ConsoleView;

public class ChessApplication {

    public static void main(String[] args) {
        final ChessGameController chessGameController = new ChessGameController(new ConsoleView());
        chessGameController.service(System.in);
    }
}
