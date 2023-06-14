package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 룩이 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositions() {
        Rook rook = Rook.createBlack(new Position("a1"));

        List<Position> expectedPositions = IntStream.rangeClosed(2, 8)
                .mapToObj(i -> new Position("a" + i))
                .collect(Collectors.toList());

        expectedPositions.addAll(IntStream.rangeClosed('b', 'h')
                .mapToObj(c -> new Position(String.valueOf((char) c) + 1))
                .collect(Collectors.toUnmodifiableList()));

        assertThat(rook.getValidMovePositions()).containsExactlyInAnyOrderElementsOf(expectedPositions);
    }

}
