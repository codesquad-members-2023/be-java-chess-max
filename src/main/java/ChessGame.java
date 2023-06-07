public class ChessGame {

    private final Board board;
    private boolean keepPlaying;

    public ChessGame() {
        this.board = new Board();
        this.keepPlaying = true;
    }

    public void play(String input) {
        if (input.equals("start")) {
            board.initialize();
        }
        if (input.equals("end")) {
            keepPlaying = false;
        }
    }

    public String printResult() {
        return board.print();
    }

    public boolean doesGameContinue() {
        return keepPlaying;
    }
}
