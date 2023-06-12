package chess.pieces;

public class Piece {

	private Color color;
	private Type type;

	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	public static Piece createBlank() {
		return new Piece(Color.NO_COLOR, Type.NO_PIECE);
	}

	public static Piece createWhite(Type type) {
		return new Piece(Color.WHITE, type);
	}

	public static Piece createBlack(Type type) {
		return new Piece(Color.BLACK, type);
	}

	public boolean isWhite() {
		return this.color.equals(Color.WHITE);
	}

	public boolean isBlack() {
		return this.color.equals(Color.BLACK);
	}

	public enum Color {
		WHITE, BLACK, NO_COLOR;
	}

	public enum Type {
		PAWN('p', 1.0),
		ROOK('r', 5.0),
		KNIGHT('n', 2.5),
		BISHOP('b', 3.0),
		QUEEN('q', 9.0),
		KING('k', 0.0),
		NO_PIECE('.', 0.0);

		private char representation;
		private double defaultPoint;

		Type(char representation, double defaultPoint) {
			this.representation = representation;
			this.defaultPoint = defaultPoint;
		}

		public char getWhiteRepresentation() {
			return representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(representation);
		}

		public double getDefaultPoint() {
			return defaultPoint;
		}
	}
}
