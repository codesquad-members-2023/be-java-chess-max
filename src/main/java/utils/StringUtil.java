package utils;

public class StringUtil {

    private static final String NEW_LINE = System.lineSeparator();

    private StringUtil() {

    }

    public static String appendNewLine(String raw) {
        return raw + NEW_LINE;
    }
}
