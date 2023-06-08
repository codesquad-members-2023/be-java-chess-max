package com.chessgame.app.chess;

import java.util.Scanner;

import com.chessgame.app.chess.board.Board;
import com.chessgame.app.chess.piece.position.Rank;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("[체스 게임] (start: 게임 시작, end: 게임 종료)");
		String command = scanner.nextLine();

		if(command.equals("start")) {
			Board board = new Board();
			board.initialize();

			for(Rank rank : Rank.values()) {
				if(rank == Rank.BLOCK) continue;
				System.out.println(board.getResult(rank));
			}

		} else if(command.equals("end")) {
			System.exit(0);
		}

	}
}
