package chess.pieces.type;

public enum Type {

	PAWN('p'),
	ROOK('r'),
	KNIGHT('n'),
	BISHOP('b'),
	QUEEN('q'),
	KING('k'),
	DUMMY('.');

	private final char figure;

	Type(final char figure) {
		this.figure = figure;
	}

	public char getFigure() {
		return figure;
	}
}
