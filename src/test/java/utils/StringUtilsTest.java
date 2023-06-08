package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    @DisplayName("문자열 뒤에 '\r\n' 문자를 추가한다")
    public void appendNewLine() {
        // given
        String str = "aaaaaaaaa";
        // when
        str = StringUtils.appendNewLine(str);
        // then
        assertThat(str).isEqualTo("aaaaaaaaa\r\n");
    }
}
