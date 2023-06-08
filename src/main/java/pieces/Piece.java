package pieces;

public class Piece {

    public enum Color {

        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NOTYPE('.', 0.0);

        private final char shape;
        private final double score;

        private Type(char shape, double score) {
            this.shape = shape;
            this.score = score;
        }

        public char getShape() {
            return shape;
        }

        public double getScore() {
            return score;
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

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isPawn() {
        return type == Type.PAWN;
    }

    public boolean isRook() {
        return type == Type.ROOK;
    }

    public boolean isKnight() {
        return type == Type.KNIGHT;
    }

    public boolean isBishop() {
        return type == Type.BISHOP;
    }

    public boolean isQueen() {
        return type == Type.QUEEN;
    }

    public boolean isKing() {
        return type == Type.KING;
    }

    public boolean isBlank() {
        return color == Color.NOCOLOR && type == Type.NOTYPE;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getShape() {
        if (color == Color.BLACK) {
            return Character.toUpperCase(type.getShape());
        }
        return type.getShape();
    }

    public double getScore() {
        return type.score;
    }

    public boolean isColor(Piece.Color color) {
        return this.color == color;
    }

    public boolean isType(Piece.Type type) {
        return this.type == type;
    }
}
