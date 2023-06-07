package com.chessgame.app.chess.system;

import java.util.Scanner;

public class ConsoleInputView {

	private Scanner scanner;

	public ConsoleInputView() {
		this.scanner = new Scanner(System.in);
	}

	public String inputStartCommand() {
		System.out.println("[체스 게임] (start: 게임 시작, end: 게임 종료)");
		return scanner.nextLine();
	}
}
