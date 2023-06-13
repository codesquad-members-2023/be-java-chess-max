package kr.codesqaud.chessgame.exception;

public class InvalidTurnException extends RuntimeException {

    public InvalidTurnException(final String message) {
        super(message);
    }
}
