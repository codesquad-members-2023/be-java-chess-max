package chess.game;

import chess.board.Board;
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
			if (command.equals("end")) {
				break;
			}
		}
	}
}
