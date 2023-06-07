package chess.color;

import lombok.Getter;

@Getter
public enum Color {

	BLACK("black"),
	WHITE("white");

	private String color;

	Color(String color) {
		this.color = color;
	}
}
