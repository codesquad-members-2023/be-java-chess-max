package kr.codesqaud.chessgame.chess.board;

import java.util.List;
import java.util.Optional;
import kr.codesqaud.chessgame.chess.pieces.Piece;
import kr.codesqaud.chessgame.chess.pieces.Position;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public interface Board {

    int SIZE = 8;

    void initialize();

    void move(final String sourcePosition, final String targetPosition);

    String showBoard();

    Color getColorByPosition(final String position); // 위치에 존재하는 Piece의 색상을 응답합니다.

    void setPiece(final Position position, final Piece piece);

    Piece findPiece(Position position);

    List<Position> possiblePath(Position position);

    Optional<Piece> findPieceBy(Color color, Type type);

    boolean checkmate(Color white);
}
