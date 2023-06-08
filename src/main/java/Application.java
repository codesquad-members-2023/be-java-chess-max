import controller.ChessGame;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessGame game = new ChessGame();

        do {
            String input = scanner.nextLine().trim();
            game.play(input);
            System.out.println(game.printResult());
        } while(game.doesGameContinue());
    }
}
