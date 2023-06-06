package chess;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        // TODO: 다른 명령어가 또 들어올 수 있으니 일단 예외 처리는 나중에
        while (true) {
            String command = sc.nextLine();

            if (endGame(command)) break;

            startGame(command);
        }

        sc.close();
    }

    private static boolean endGame(final String command) {
        if (Objects.equals(command, "end")) {
            System.out.println("체스 게임을 종료합니다.");
            return true;
        }

        return false;
    }

    private static void startGame(final String command) {
        if (Objects.equals(command, "start")) {
            System.out.println("체스 게임을 시작합니다.");

            Board board = new Board();
            board.initialize();
        }
    }
}
