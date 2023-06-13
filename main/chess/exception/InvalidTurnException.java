package chess.exception;

public class InvalidTurnException extends RuntimeException {

    public InvalidTurnException() {
        super("해당 색상의 말을 옮길 차례가 아닙니다.");
    }

}
