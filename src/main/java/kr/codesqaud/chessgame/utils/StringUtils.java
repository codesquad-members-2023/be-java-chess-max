package kr.codesqaud.chessgame.utils;

public final class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
        throw new RuntimeException("이 클래스는 유틸 클래스입니다. 객체를 생성할 수 없습니다.");
    }

    public static String appendNewLine(String text) {
        return text + NEWLINE;
    }
}
