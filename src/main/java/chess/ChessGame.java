package chess;

import java.util.Scanner;

public class ChessGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("체스 게임을 시작합니다.");
		System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");

		loop:
		while (true) {
			System.out.println("명령을 입력하세요.");
			String command = scanner.next();
			switch (command) {
				case "start":
					Board board = new Board();
					board.initialize();
					System.out.println(board.print());
					break;
				case "end":
					System.out.println("체스 게임을 종료합니다.");
					break loop;
				default:
					System.out.println(command + "는 지원하지 않는 명령어입니다.");
					break;
			}
		}
		scanner.close();
	}
}
