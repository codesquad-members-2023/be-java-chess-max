package kr.codesqaud.chessgame.chess;

public class ConsoleView implements View {

    @Override
    public void showBoard(final Board board) {
        System.out.println(board.showBoard());
    }

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
    }
}
