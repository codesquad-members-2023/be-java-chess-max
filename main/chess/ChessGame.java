package chess;

import chess.exception.InvalidTurnException;
import chess.piece.Color;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;

public class ChessGame {

    private final Board board = new Board();
    private Color turn;

    public void setUp() {
        board.initialize();
        this.turn = WHITE;
    }

    public void move(final String sourcePosition, final String targetPosition) {
        checkTurn(sourcePosition);
        board.move(sourcePosition, targetPosition);
        changeTurn();
    }

    private void checkTurn(final String sourcePosition) {
        if (!board.findPiece(sourcePosition).isColor(turn)) {
            throw new InvalidTurnException();
        }
    }

    private void changeTurn() {
        if (turn.equals(WHITE)) {
            turn = BLACK;
        } else {
        turn = WHITE;
        }
    }

    public Board getBoard() {
        return board;
    }

}
