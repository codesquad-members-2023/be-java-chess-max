package chess;

import java.util.Scanner;

public class ChessGame {

    public static final String RUN_COMMAND = "start";
    public static final String EXIT_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Chess Game ---");
        System.out.println("--- 게임 시작은 start, 게임 종료는 end를 입력하세요 ---");

        while (true) {
            String command = scanner.nextLine();

            if (command.equals(RUN_COMMAND)) {
                Board board = new Board();
                board.initialize();
                System.out.println(board.show());
            } else if (command.equals(EXIT_COMMAND)) {
                break;
            } else {
                System.out.println("'" + command + "'는 지원하지 않는 명령어입니다");
            }
        }
    }
}
