package chess.pieces;

public interface Piece {

    boolean verifyColor(Color color);
    Representation getRepresentation();
}
