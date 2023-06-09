package chess.board;

import chess.color.Color;
import chess.pieces.Piece;
import chess.pieces.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rank {

	private List<Piece> rank = new ArrayList<>();

	public void init(final List<Piece> rank) {
		this.rank = rank;
	}

	public int countPieces(final Type type, final Color color) {
		return (int) rank.stream()
				.filter(piece -> piece.getType() == type)
				.filter(piece -> piece.getColor() == color)
				.count();
	}

	@Override
	public String toString() {
		return rank.stream()
				.map(Piece::toString)
				.collect(Collectors.joining());
	}
}
