package chess.pieces;

import chess.Board;
import chess.Position;

public interface Piece {

    boolean verifyColor(Color color);

    String getRepresentation();

    double getScore();

    Color getColor();

    Position[] getCanMovePositions(Position position, Board board);
}
