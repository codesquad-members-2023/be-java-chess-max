package chess.pieces.knight;

import static chess.pieces.PieceUtility.pieceMove;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.DefaultPiece;
import chess.pieces.Type;

public abstract class Knight extends DefaultPiece {

    private final static int[][] steps = {{-2, -1}, {-2, 1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2},
            {2, -1}, {2, 1}};

    public Knight(Color color) {
        super(color);
    }

    public double getScore() {
        return Type.KNIGHT.getScore();
    }

    @Override
    public Position[] getCanMovePositions(Position position, Board board) {
        return pieceMove(this, position, board, steps);
    }
}
