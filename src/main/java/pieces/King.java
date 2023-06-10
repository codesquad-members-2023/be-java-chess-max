package pieces;

public class King extends Piece {
    public King(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static King createWhite(Position position) {
        return new King(Color.WHITE, Type.KING, position);
    }

    public static King createBlack(Position position) {
        return new King(Color.BLACK, Type.KING, position);
    }
}
