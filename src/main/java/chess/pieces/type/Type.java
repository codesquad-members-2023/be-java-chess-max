package chess.pieces.type;

public enum Type {

	PAWN('p', 1),
	ROOK('r', 5),
	KNIGHT('n', 2.5F),
	BISHOP('b', 3),
	QUEEN('q', 9),
	KING('k', 0),
	DUMMY('.', 0);

	private final char figure;
	private final float point;

	Type(char figure, float point) {
		this.figure = figure;
		this.point = point;
	}

	public char getFigure() {
		return figure;
	}

	public float getPoint() {
		return point;
	}
}
