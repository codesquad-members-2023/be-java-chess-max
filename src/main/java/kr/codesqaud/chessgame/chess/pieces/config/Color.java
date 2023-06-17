package kr.codesqaud.chessgame.chess.pieces.config;

public enum Color {
    WHITE("WHITE"), BLACK("BLACK"), NOCOLOR("NOCOLOR");

    private String value;

    Color(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

