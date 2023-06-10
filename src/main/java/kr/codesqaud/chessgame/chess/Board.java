package kr.codesqaud.chessgame.chess;

public interface Board {

    void initialize();

    void move(final String sourcePosition, final String targetPosition);

    String showBoard();
}
