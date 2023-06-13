package chess.pieces;

public abstract class DefaultPiece implements Piece {

    Color color;

    public DefaultPiece(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
