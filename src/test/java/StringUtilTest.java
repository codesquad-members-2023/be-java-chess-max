import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtil.appendNewLine;

public class StringUtilTest {

    @Test
    @DisplayName("appendNewline(): 영어를 넣어주면 자동으로 개행문자를 추가한다")
    public void appendNewLineInEnglish() {
        String raw = "Nag is genius.";

        String edited = appendNewLine(raw);

        assertThat(edited).isEqualTo(raw + System.lineSeparator());
    }

    @Test
    @DisplayName("appendNewline(): 한글을 넣어주면 자동으로 개행문자를 추가한다")
    public void appendNewLineInKorean() {
        String raw = "나그는 천재다.";

        String edited = appendNewLine(raw);

        assertThat(edited).isEqualTo(raw + System.lineSeparator());
    }

    @Test
    @DisplayName("appendNewline(): 빈 문자열을 넣어주면 자동으로 개행문자를 추가한다")
    public void appendNewLineInEmptyString() {
        String raw = "";

        String edited = appendNewLine(raw);

        assertThat(edited).isEqualTo(raw + System.lineSeparator());
    }

    @Test
    @DisplayName("appendNewline(): 빈 칸으로 이루어진 문자열을 넣어주면 자동으로 개행문자를 추가한다")
    public void appendNewLineInBlank() {
        String raw = "         ";

        String edited = appendNewLine(raw);

        assertThat(edited).isEqualTo(raw + System.lineSeparator());
    }
}
