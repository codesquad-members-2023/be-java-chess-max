package pieces;

public class Bishop extends Piece {
    public Bishop(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Bishop createWhite(Position position) {
        return new Bishop(Color.WHITE, Type.BISHOP, position);
    }

    public static Bishop createBlack(Position position) {
        return new Bishop(Color.BLACK, Type.BISHOP, position);
    }
}
