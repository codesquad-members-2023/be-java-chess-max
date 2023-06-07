package chess.board;

import chess.color.Color;
import chess.pieces.Dummy;
import chess.pieces.Pawn;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

	private static final int BOARD_SIZE = 8;

	private final Piece[][] board;

	public Board() {
		this.board = new Piece[BOARD_SIZE][BOARD_SIZE];
	}

	public void initialize() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			Arrays.fill(board[i], new Dummy());
		}

		int initialPawnRow = 1;
		Arrays.fill(board[initialPawnRow], new Pawn(Color.BLACK));
		Arrays.fill(board[BOARD_SIZE - initialPawnRow - 1], new Pawn(Color.WHITE));
	}

	public String print() {
		StringBuilder boardFigure = new StringBuilder();
		for (int row = 0; row < BOARD_SIZE; row++) {
			String boardLine = Arrays.stream(board[row])
					.map(Object::toString)
					.collect(Collectors.joining());
			boardFigure.append(boardLine).append("\n");
		}

		System.out.println(boardFigure);
		return boardFigure.toString();
	}
}
