package chess;

import java.util.ArrayList;
import java.util.stream.Collectors;

import chess.pieces.Piece;

public class Rank {
	private ArrayList<Piece> pieces = new ArrayList<>(8);

	public Rank() {}

	public void addPieces(Piece piece) {
		pieces.add(piece);
	}

	public Piece getPiece(int x) {
		return pieces.get(x);
	}

	@Override
	public String toString() {
		return pieces.stream()
			.map(p -> {
				if (p.getColor().equals(Piece.Color.BLACK)) {
					return Character.toString(p.getType().getBlackRepresentation());
				} else {
					return Character.toString(p.getType().getWhiteRepresentation());
				}
			})
			.collect(Collectors.joining());
	}

	public int count(Piece.Color color, Piece.Type type) {
		int count = 0;
		for (Piece piece: pieces) {
			if(piece.getColor().equals(color) && piece.getType().equals(type)) {
				count++;
			}
		}
		return count;
	}
}
