package chess;

public class Game {

    private final Board board;


    public Game(Board board) {
        this.board = board;
    }

    void init() {
        board.initialize();
    }
}
