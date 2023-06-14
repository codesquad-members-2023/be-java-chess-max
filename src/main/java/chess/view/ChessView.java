package chess.view;

import chess.board.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ChessView {

	private static final String NEW_LINE = System.lineSeparator();

	public String printBoard(final List<Rank> board) {
		return board.stream()
				.map(Object::toString)
				.collect(Collectors.joining(NEW_LINE));
	}
}
