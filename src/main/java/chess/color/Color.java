package chess.color;

import chess.exception.BusinessException;
import chess.exception.ErrorCode;

import java.util.Arrays;

public enum Color {
	WHITE("white"),
	BLACK("black");

	private final String value;

	Color(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Color getColor(final String color) {
		return Arrays.stream(Color.values())
				.filter(c -> c.value.equals(color))
				.findFirst()
				.orElseThrow(() -> new BusinessException(ErrorCode.NO_MATCH_COLOR));
	}
}
