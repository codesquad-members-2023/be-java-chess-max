package chess.game;

import chess.board.Board;
import chess.board.Position;
import chess.exception.BusinessException;
import chess.pieces.color.Color;
import chess.view.ChessView;
import chess.view.InputUtils;

public class ChessGame {

	private static final String START_COMMAND = "start";
	private static final String MOVE_COMMAND = "move";
	private static final String END_COMMAND = "end";

	private final Board board = new Board();
	private final ChessView chessView = new ChessView();

	private Color turn = Color.WHITE;

	public ChessGame() {
		board.initialize();
	}

	public void run() {
		System.out.println("-----체스 게임-----");
		System.out.println("게임 시작 커맨드 : start");
		System.out.println("기물 이동 커맨드 : move src dst (ex. move a1 a3)");
		System.out.println("게임 종료 커맨드 : end");
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
			} catch (BusinessException e) {
				System.out.println(e.getErrorCode().getDescription());
			}
		}
	}

	private void move(final String from, final String to) {
		board.checkTurn(turn, new Position(from));
		board.move(new Position(from), new Position(to));
		turn = Color.changeTurn(turn);
	}
}
