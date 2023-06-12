package chess.pieces.bishop;

import static chess.pieces.PieceUtility.pieceMove;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.DefaultPiece;
import chess.pieces.Type;

public abstract class Bishop extends DefaultPiece {

    private final static int[][] steps = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public Bishop(Color color) {
        super(color);
    }

    public double getScore() {
        return Type.BISHOP.getScore();
    }

    @Override
    public Position[] getCanMovePositions(Position position, Board board) {
        return pieceMove(this, position, board, steps);
    }
}
