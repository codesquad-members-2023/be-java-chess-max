package chess.pieces;

public interface Piece {

    boolean verifyColor(Color color);

    String getRepresentation();

    double getScore();
}
