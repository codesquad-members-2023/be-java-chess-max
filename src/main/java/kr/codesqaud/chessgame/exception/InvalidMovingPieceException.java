package kr.codesqaud.chessgame.exception;

public class InvalidMovingPieceException extends RuntimeException {

    public InvalidMovingPieceException(final String message) {
        super(message);
    }
}
