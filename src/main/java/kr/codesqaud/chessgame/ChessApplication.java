package kr.codesqaud.chessgame;

import kr.codesqaud.chessgame.chess.ChessGame;

import java.io.FileInputStream;

public class ChessApplication {

    public static void main(String[] args) {
        final ChessGame chessGame = ChessGame.getInstance();
        chessGame.start(System.in);
    }
}
