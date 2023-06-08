package com.chessgame.app.chess.system;

import com.chessgame.app.chess.board.Board;

public class ConsoleGame {

	public void execute() {
		ConsoleInputView inputView = new ConsoleInputView();

		boolean isRunning = true;
		while (isRunning) {
			isRunning = controlGame(inputView);
		}
	}

	private boolean controlGame(ConsoleInputView inputView) {

		String command = inputView.inputStartCommand();

		switch (command) {
			case "start":
				makeBoard();
				return true;
			case "end":
				System.out.println("게임을 종료합니다.");
				return false;
			default:
				System.out.println("잘못된 명령어를 입력하였습니다.");
				return true;
		}
	}

	private void makeBoard() {
		Board board = new Board();
		board.initialize();
		System.out.println(board.getResult());
	}

}
