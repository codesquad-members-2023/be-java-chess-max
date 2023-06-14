package chess;

import chess.view.ChessView;

import java.util.Scanner;

public class ChessGameStarter {

    public static final String RUN_COMMAND = "start";
    public static final String EXIT_COMMAND = "end";
    public static final String MOVE_COMMAND = "move";

    private final ChessView chessView;
    private final ChessGame chessGame;

    public ChessGameStarter(ChessView chessView, ChessGame chessGame) {
        this.chessView = chessView;
        this.chessGame = chessGame;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            try {
                if (command.equals(RUN_COMMAND)) {
                    chessGame.setUp();
                    System.out.println(chessView.view(chessGame.getBoard()));
                } else if (command.startsWith(MOVE_COMMAND)) {
                    final String[] positions = command.split(" ");
                    final String source = positions[1];
                    final String target = positions[2];
                    chessGame.move(source, target);
                    System.out.println(chessView.view(chessGame.getBoard()));
                } else if (command.equals(EXIT_COMMAND)) {
                    break;
                } else {
                    System.out.println("'" + command + "'는 지원하지 않는 명령어입니다");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("--- Chess Game ---");
        System.out.println("--- 게임 시작은 start, 게임 종료는 end를 입력하세요 ---");

        final ChessView chessView = new ChessView();
        final ChessGame chessGame = new ChessGame();

        ChessGameStarter chessGameStarter = new ChessGameStarter(chessView, chessGame);
        chessGameStarter.play();

    }

}
