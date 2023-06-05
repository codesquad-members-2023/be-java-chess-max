package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.chess.ChessGame;

public class ChessApplication {
    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame(System.in);
        chessGame.start();
    }
}
