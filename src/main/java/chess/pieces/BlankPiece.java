package chess.pieces;

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
}
