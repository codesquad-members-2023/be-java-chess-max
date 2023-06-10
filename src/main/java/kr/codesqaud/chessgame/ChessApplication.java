package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.chess.ChessGameController;

public class ChessApplication {

    public static void main(String[] args) {
        final ChessGameController chessGameController = new ChessGameController();
        chessGameController.run(System.in);
    }
}
