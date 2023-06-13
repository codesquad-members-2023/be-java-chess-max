package chess.game;

import chess.board.Board;
import chess.board.Position;
import chess.view.ChessView;
import chess.view.InputUtils;

public class ChessGame {

	private static final String START_COMMAND = "start";
	private static final String MOVE_COMMAND = "move";
	private static final String END_COMMAND = "end";

	private final Board board = new Board();
	private final ChessView chessView = new ChessView();

	public ChessGame() {
		board.initialize();
	}

	public void run() {
		while (true) {
			String command = InputUtils.getCommand();

			try {
				if (command.equals(START_COMMAND)) {
					System.out.println("게임을 시작합니다!");
					System.out.println(chessView.printBoard(board.getBoard()));
				} else if (command.startsWith(MOVE_COMMAND)) {
					String[] tokens = command.split(" ");
					move(tokens[1], tokens[2]);
					System.out.println(chessView.printBoard(board.getBoard()));
				} else if (command.equals(END_COMMAND)) {
					break;
				} else {
					System.out.println(command + " 명령어는 지원하지 않습니다.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void move(final String from, final String to) {
		board.move(new Position(from), new Position(to));
	}
}
