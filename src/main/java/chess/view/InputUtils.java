package chess.view;

import java.util.Scanner;

public final class InputUtils {

	private static final Scanner scanner = new Scanner(System.in);

	private InputUtils() {
	}

	public static String getCommand() {
		return scanner.nextLine();
	}
}
