package chess.pieces;

import static chess.pieces.Color.NONE;

import chess.Board;
import chess.Position;
import java.util.ArrayList;
import java.util.List;

public class PieceUtility {

    public static Position[] pieceMove(Piece piece, Position position, Board board, int[][] steps) {
        int column = position.getColumn();
        int row = position.getRow();
        List<Position> positions = new ArrayList<>();
        for (int[] step : steps) {
            int nextRow = row + step[0];
            int nextColumn = column + step[1];
            if (nextRow >= 0 && nextRow < 8 && nextColumn >= 0 && nextColumn < 8) {
                Position nextPosition = new Position(nextRow, nextColumn);
                if (!piece.verifyColor(board.findPiece(nextPosition).getColor())) {
                    positions.add(nextPosition);
                }
            }
        }
        return positions.toArray(new Position[0]);
    }

    public static Position[] getDirectDirectionPositions(Position position, Board board,
            Color color, Position direction, int limit) {
        List<Position> positions = new ArrayList<>();
        int nextColumn = position.getColumn();
        int nextRow = position.getRow();
        int repeatCount = 0;

        while (repeatCount < limit && nextRow >= 0 && nextRow < 8 && nextColumn >= 0
                && nextColumn < 8) {
            repeatCount++;
            nextColumn = nextColumn + direction.getColumn();
            nextRow = nextRow + direction.getRow();
            if (nextRow < 0 || nextRow >= 8 || nextColumn < 0 || nextColumn >= 8) {
                break;
            }
            Position nextPosition = new Position(nextRow, nextColumn);
            Piece nextPiece = board.findPiece(nextPosition);
            if (nextPiece.verifyColor(color)) {
                return positions.toArray(new Position[0]);
            }
            positions.add(nextPosition);
            if (!nextPiece.getColor().equals(NONE)) {
                return positions.toArray(new Position[0]);
            }
        }
        return positions.toArray(new Position[0]);
    }
}
