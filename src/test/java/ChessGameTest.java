import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtil.appendNewLine;

public class ChessGameTest {

    private ChessGame game;

    @BeforeEach
    public void initialize() {
        this.game = new ChessGame();
    }

    @Test
    @DisplayName("game()에 start를 입력하면 board가 initialize된다")
    public void gameStart() {
        String figure = appendNewLine("........") +
                appendNewLine("PPPPPPPP") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("pppppppp") +
                appendNewLine("........");

        game.play("start");

        assertThat(game.printResult()).isEqualTo(figure);
    }

    @Test
    @DisplayName("game()에 end를 입력하면 keepPlaying이 false로 바뀐다")
    public void gameEnd() {
        game.play("end");

        assertThat(game.doesGameContinue()).isFalse();
    }
}
