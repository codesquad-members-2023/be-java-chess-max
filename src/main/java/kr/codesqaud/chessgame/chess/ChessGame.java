package kr.codesqaud.chessgame.chess;

import kr.codesqaud.chessgame.chess.board.Board;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.exception.InvalidTurnException;

public class ChessGame {

    private final Board board;
    private Color currentTurn;

    public ChessGame(Board board) {
        this.board = board;
        this.currentTurn = Color.WHITE;
    }

    public void initialize() {
        board.initialize();
    }


    public boolean move(final String sourcePosition, final String targetPosition) {
        verifyMyOwnPiece(sourcePosition);
        return board.move(sourcePosition, targetPosition);
    }

    private void verifyMyOwnPiece(final String sourcePosition) {
        if (currentTurn != board.getColorByPosition(sourcePosition)) {
            throw new InvalidTurnException(currentTurn.name() + "색 기물을 선택해주세요.");
        }
    }

    public String showBoard() {
        return board.showBoard();
    }

    public Color nextTurn() {
        if (currentTurn == Color.WHITE) {
            currentTurn = Color.BLACK;
        } else {
            currentTurn = Color.WHITE;
        }
        return currentTurn;
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }

    public Color checkmate() {
        if (board.checkmate(Color.WHITE)) {
            return Color.BLACK;
        } else if (board.checkmate(Color.BLACK)) {
            return Color.WHITE;
        }
        return Color.NOCOLOR;
    }

    public Board getBoard() {
        return board;
    }

    public double getPointByWhite() {
        return board.getPointBy(Color.WHITE);
    }

    public double getPointByBlack() {
        return board.getPointBy(Color.BLACK);
    }


}
