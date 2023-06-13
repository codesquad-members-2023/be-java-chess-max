package chess.pieces.pawn;

import static chess.pieces.Color.WHITE;
import static chess.pieces.PieceUtility.getDirectDirectionPositions;
import static chess.pieces.PieceUtility.pieceMove;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.Representation;

public class WhitePawn extends Pawn {

    private final static int[][] diagonalSteps = {{-1, -1}, {-1, 1}};
    private boolean isCaptured;

    public WhitePawn() {
        super(WHITE);
    }

    @Override
    public boolean verifyColor(Color color) {
        return WHITE.equals(color);
    }

    @Override
    public String getRepresentation() {
        return Representation.WHITE_PAWN.getValue();
    }

    @Override
    public Position[] getCanMovePositions(Position position, Board board) {
        if (isCaptured) {
            return pieceMove(this, position, board, diagonalSteps);
        }
        return getDirectDirectionPositions(position, board, getColor(), new Position(-1, 0), 2);
    }

    public void capturePiece() {
        isCaptured = true;
    }
}
