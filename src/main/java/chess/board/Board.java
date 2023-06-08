package chess.board;

import chess.color.Color;
import chess.pieces.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

	private static final int BOARD_SIZE = 8;
	private static final String NEW_LINE = System.getProperty("line.separator");

	private final Piece[][] board;

	public Board() {
		this.board = new Piece[BOARD_SIZE][BOARD_SIZE];
	}

	public void initialize() {
		initPieces(0, Color.BLACK);
		initPieces(BOARD_SIZE - 1, Color.WHITE);
		initPawns(1, Color.BLACK);
		initPawns(BOARD_SIZE - 2, Color.WHITE);
		initDummyPieces();
	}

	private void initPieces(int row, Color color) {
		board[row][0] = board[row][7] = Rook.of(color);
		board[row][1] = board[row][6] = Knight.of(color);
		board[row][2] = board[row][5] = Bishop.of(color);
		board[row][3] = Queen.of(color);
		board[row][4] = King.of(color);
	}

	private void initPawns(int row, Color color) {
		Arrays.fill(board[row], Pawn.of(color));
	}

	private void initDummyPieces() {
		for (int row = 2; row < BOARD_SIZE - 2; row++) {
			Arrays.fill(board[row], Dummy.of());
		}
	}

	public String print() {
		StringBuilder boardFigure = new StringBuilder();
		for (int row = 0; row < BOARD_SIZE; row++) {
			String boardLine = Arrays.stream(board[row])
					.map(Object::toString)
					.collect(Collectors.joining());
			boardFigure.append(boardLine).append(NEW_LINE);
		}

		System.out.println(boardFigure);
		return boardFigure.toString();
	}
}
