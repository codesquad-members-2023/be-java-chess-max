package chess.game;

import chess.board.Board;
import chess.board.Position;
import chess.view.InputUtils;

public class ChessGame {

	private final Board board = new Board();

	public ChessGame() {
		board.initialize();
	}

	public void run() {
		System.out.print("체스 게임을 시작하려면 'start' 를 입력해주세요. : ");
		String command = InputUtils.getCommand();
		if (!command.equals("start")) {
			System.out.println("종료합니다..");
			return;
		}
		while (true) {
			board.print();
			System.out.print("커맨드를 입력해주세요. (종료하려면 'end'를 입력해주세요.) : ");
			command = InputUtils.getCommand();
			if (command.startsWith("move")) {
				String[] tokens = command.split(" ");
				move(tokens[1], tokens[2]);
			}
			if (command.equals("end")) {
				break;
			}
		}
	}

	private void move(final String from, final String to) {
		board.move(new Position(from), new Position(to));
	}
}
