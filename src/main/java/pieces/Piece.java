package pieces;

public class Piece {

    public enum Color {

        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), 
        QUEEN('q'), KING('k'), NOTYPE('.');

        private final char shape;

        private Type(char shape) {
            this.shape = shape;
        }

        public char getShape() {
            return shape;
        }
    }
    
    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NOTYPE);
    }

    public boolean isBlackPawn() {
        return color.equals(Color.BLACK) && type.equals(Type.PAWN);
    }

    public boolean isWhitePawn() {
        return color.equals(Color.WHITE) && type.equals(Type.PAWN);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getShape() {
        return type.getShape();
    }
}
