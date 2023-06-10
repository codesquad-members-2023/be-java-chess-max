package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.controller.ChessGameController;

public class ChessApplication {

    public static void main(String[] args) {
        final ChessGameController chessGameController = new ChessGameController();
        chessGameController.service(System.in);
    }
}
