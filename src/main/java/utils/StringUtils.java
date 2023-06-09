package utils;

public class StringUtils {
    public static final String NEW_LINE = System.lineSeparator();

    private StringUtils() {
    }

    public static String appendNewLine(final String text) {
        return text + NEW_LINE;
    }
}
