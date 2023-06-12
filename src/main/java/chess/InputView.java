package chess;

import java.util.Optional;
import java.util.Scanner;

public class InputView {

    static Optional<Position> getPosition() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            return Optional.of(Position.parse(input));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

}
