package chess.pieces;

public class Pawn {
	public final static String WHITE_COLOR = "white";
	public final static String BLACK_COLOR = "black";
	public final static char WHITE_REPRESENTATION = 'p';
	public final static char BLACK_REPRESENTATION = 'P';

	private String color;
	private char representation;

	public Pawn() {
		this.color = WHITE_COLOR;
		this.representation = WHITE_REPRESENTATION;
	}

	public Pawn(String color, char representation) {
		this.color = color;
		this.representation = representation;
	}

	public String getColor() {
		return color;
	}

	public char getRepresentation() {
		return representation;
	}
}
