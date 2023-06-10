package pieces;

public class Knight extends Piece {
    public Knight(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Knight createWhite(Position position) {
        return new Knight(Color.WHITE, Type.KNIGHT, position);
    }

    public static Knight createBlack(Position position) {
        return new Knight(Color.BLACK, Type.KNIGHT, position);
    }
}
