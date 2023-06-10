package kr.codesqaud.chessgame.chess;

import java.util.List;
import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Type;

public interface Board {

    void initialize();

    void initializeEmpty();

    void move(final String position, final Piece piece);

    void move(final String sourcePosition, final String targetPosition);

    String showBoard();

    int getPieceCount(final Color color, final Type type);

    int size();

    Piece findPiece(final String position);

    double calculatePoint(final Color color);

    List<Piece> sortDecreaseByColor(final Color color);

    List<Piece> sortIncreaseByColor(final Color color);
}
