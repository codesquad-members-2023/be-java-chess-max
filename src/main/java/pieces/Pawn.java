package pieces;

public class Pawn extends Piece {
    public Pawn(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Pawn createWhite(Position position) {
        return new Pawn(Color.WHITE, Type.PAWN, position);
    }

    public static Pawn createBlack(Position position) {
        return new Pawn(Color.BLACK, Type.PAWN, position);
    }
}
