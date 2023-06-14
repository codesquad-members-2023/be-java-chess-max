package chess.view;

import java.util.Scanner;

public final class InputUtils {

	private static final Scanner scanner = new Scanner(System.in);

	private InputUtils() {
	}

	public static String getCommand() {
		System.out.print("명령어를 입력해주세요 : ");
		return scanner.nextLine();
	}
}
