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


    public void move(final String sourcePosition, final String targetPosition) {
        verifyMyOwnPiece(sourcePosition);
        board.move(sourcePosition, targetPosition);
    }

    private void verifyMyOwnPiece(final String sourcePosition) {
        if (currentTurn != board.getColorByPosition(sourcePosition)) {
            throw new InvalidTurnException(currentTurn.name() + "색 기물을 선택해주세요.");
        }
    }

    public String showBoard() {
        return board.showBoard();
    }

    public void nextTurn() {
        if (currentTurn == Color.WHITE) {
            currentTurn = Color.BLACK;
        } else {
            currentTurn = Color.WHITE;
        }
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }


}
