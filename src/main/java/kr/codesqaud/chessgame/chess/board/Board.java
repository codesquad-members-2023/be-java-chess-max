package kr.codesqaud.chessgame.chess.board;

import kr.codesqaud.chessgame.chess.pieces.config.Color;

public interface Board {

    int SIZE = 8;

    void initialize();

    void move(final String sourcePosition, final String targetPosition);

    String showBoard();

    Color getColorByPosition(final String position); // 위치에 존재하는 Piece의 색상을 응답합니다.
}
