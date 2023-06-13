package chess.pieces.king;

import static chess.pieces.PieceUtility.pieceMove;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.DefaultPiece;
import chess.pieces.Type;

public abstract class King extends DefaultPiece {

    private final static int[][] steps = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {0, 1}, {0, -1},
            {1, 0}, {-1, 0}};

    public King(Color color) {
        super(color);
    }

    public double getScore() {
        return Type.KING.getScore();
    }

    @Override
    public Position[] getCanMovePositions(Position position, Board board) {
        return pieceMove(this, position, board, steps);
    }
}
