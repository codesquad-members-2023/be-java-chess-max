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
		PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

		private char representation;

		Type(char representation) {
			this.representation = representation;
		}

		public char getWhiteRepresentation() {
			return representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(representation);
		}
	}
}
