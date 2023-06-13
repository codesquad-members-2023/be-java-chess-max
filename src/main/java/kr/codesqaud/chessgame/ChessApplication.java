package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.chess.ChessGame;

public class ChessApplication {

    public static void main(String[] args) {
        final ChessGame chessGame = new ChessGame();
        chessGame.run(System.in);
    }
}
