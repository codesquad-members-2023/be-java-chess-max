package chess.board;

import chess.color.Color;
import chess.pieces.*;
import chess.pieces.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

	private static final int BOARD_SIZE = 8;
	private static final String NEW_LINE = System.lineSeparator();

	private final List<Rank> board;

	public Board() {
		this.board = new ArrayList<>();
		for (int i = 0; i < BOARD_SIZE; i++) {
			board.add(new Rank());
		}
	}

	public void initialize() {
		initPieces(0, Color.BLACK);
		initPieces(BOARD_SIZE - 1, Color.WHITE);
		initPawns(1, Color.BLACK);
		initPawns(BOARD_SIZE - 2, Color.WHITE);
		initDummyPieces();
	}

	private void initPieces(int row, Color color) {
		board.get(row).init(
				List.of(Rook.of(color),
						Knight.of(color),
						Bishop.of(color),
						Queen.of(color),
						King.of(color),
						Bishop.of(color),
						Knight.of(color),
						Rook.of(color)));
	}

	private void initPawns(int row, Color color) {
		List<Piece> pawns = new ArrayList<>();
		for (int i = 0; i < BOARD_SIZE; i++) {
			pawns.add(Pawn.of(color));
		}
		board.get(row).init(pawns);
	}

	private void initDummyPieces() {
		List<Piece> dummies = new ArrayList<>();
		for (int i = 0; i < BOARD_SIZE; i++) {
			dummies.add(Dummy.of());
		}
		for (int row = 2; row < BOARD_SIZE - 2; row++) {
			board.get(row).init(dummies);
		}
	}

	public int countPieces(Type type, Color color) {
		return board.stream()
				.mapToInt(rank -> rank.countPieces(type, color))
				.sum();
	}

	public String print() {
		String boardFigure = board.stream()
				.map(Object::toString)
				.collect(Collectors.joining(NEW_LINE));

		System.out.println(boardFigure);
		return boardFigure;
	}
}
