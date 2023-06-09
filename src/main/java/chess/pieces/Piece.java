package chess.pieces;

public class Piece {
	public final static String WHITE_COLOR = "white";
	public final static String BLACK_COLOR = "black";
	public static final char WHITE_PAWN_REPRESENTATION = 'p';
	public static final char BLACK_PAWN_REPRESENTATION = 'P';
	public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
	public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
	public static final char WHITE_ROOK_REPRESENTATION = 'r';
	public static final char BLACK_ROOK_REPRESENTATION = 'R';
	public static final char WHITE_BISHOP_REPRESENTATION = 'b';
	public static final char BLACK_BISHOP_REPRESENTATION = 'B';
	public static final char WHITE_QUEEN_REPRESENTATION = 'q';
	public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
	public static final char WHITE_KING_REPRESENTATION = 'k';
	public static final char BLACK_KING_REPRESENTATION = 'K';

	private String color;
	private char representation;

	private Piece(String color, char representation) {
		this.color = color;
		this.representation = representation;
	}

	public String getColor() {
		return color;
	}

	public char getRepresentation() {
		return representation;
	}

	public Piece createWhitePawn() {
		return new Piece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
	}

	public Piece createBlackPawn() {
		return new Piece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
	}

	public Piece createWhiteKnight() {
		return new Piece(WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
	}

	public Piece createBlackKnight() {
		return new Piece(BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
	}

	public Piece createWhiteRook() {
		return new Piece(WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
	}

	public Piece createBlackRook() {
		return new Piece(BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
	}

	public Piece createWhiteBishop() {
		return new Piece(WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
	}

	public Piece createBlackBishop() {
		return new Piece(BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
	}

	public Piece createWhiteQueen() {
		return new Piece(WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
	}

	public Piece createBlackQueen() {
		return new Piece(BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
	}

	public Piece createWhiteKing() {
		return new Piece(WHITE_COLOR, WHITE_KING_REPRESENTATION);
	}

	public Piece createBlackKing() {
		return new Piece(BLACK_COLOR, BLACK_KING_REPRESENTATION);
	}
}
