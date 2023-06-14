package chess.exception;

public class InvalidPositionException extends RuntimeException{

    public InvalidPositionException() {
        super("이동할 수 없는 위치입니다.");
    }

}
