package chess.exception;

public class EmptyPieceMoveException extends RuntimeException {

    public EmptyPieceMoveException() {
        super("비어있는 공간으로 움직일 수 있는 말이 없습니다.");
    }

}
