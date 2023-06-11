package com.chessgame.app.chess.piece.position;

public enum File {
	BLOCK(0, " "),
	A(1, "a"), B(2, "b"), C(3, "c"), D(4, "d"),
	E(5, "e"), F(6, "f"), G(7, "g"), H(8, "h");

	private final int value;
	private final String stringValue;

	File(int value, String stringValue) {
		this.value = value;
		this.stringValue = stringValue;
	}

	public int getValue() {
		return value;
	}

	public String getStringValue() {
		return stringValue;
	}
}
