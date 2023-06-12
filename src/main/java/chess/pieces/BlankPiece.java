package chess.pieces;

import chess.Board;
import chess.Position;

public class BlankPiece implements Piece {

    @Override
    public boolean verifyColor(Color color) {
        return color.equals(Color.NONE);
    }

    @Override
    public String getRepresentation() {
        return Representation.BLANK_PIECE.getValue();
    }

    @Override
    public double getScore() {
        return 0;
    }

    @Override
    public Color getColor() {
        return Color.NONE;
    }

    @Override
    public Position[] getCanMovePositions(Position position, Board board) {
        return new Position[0];
    }
}
