package kr.codesqaud.chessgame.web;

import kr.codesqaud.chessgame.chess.ChessGame;
import kr.codesqaud.chessgame.chess.board.Board;

public class ChessDto {

    private Board board;
    private double pointByWhite;
    private double pointByBlack;
    private String turn;

    private ChessDto(final Board board, final double pointByWhite, final double pointByBlack, final String turn) {
        this.board = board;
        this.pointByWhite = pointByWhite;
        this.pointByBlack = pointByBlack;
        this.turn = turn;
    }

    public static ChessDto from(ChessGame chessGame) {
        return new ChessDto(chessGame.getBoard(), chessGame.getPointByWhite(), chessGame.getPointByBlack(),
            chessGame.getCurrentTurn().name());
    }

    public Board getBoard() {
        return board;
    }

    public double getPointByWhite() {
        return pointByWhite;
    }

    public double getPointByBlack() {
        return pointByBlack;
    }

    public String getTurn() {
        return turn;
    }
}
