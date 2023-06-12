package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BishopTest {

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 비숍이 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositions() {
        Bishop bishop = Bishop.createBlack(new Position("c3"));

        List<Position> expectedPositions = IntStream.rangeClosed(0, 7)
                .mapToObj(i -> new Position(String.valueOf((char) ('a' + i)) + (1 + i)))
                .filter(position -> !position.equals(new Position("c3")))
                .collect(Collectors.toList());

        expectedPositions.addAll(IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Position(String.valueOf((char) ('a' + i)) + (5 - i)))
                .filter(Position::isValidBoardPosition)
                .filter(position -> !position.equals(new Position("c3")))
                .collect(Collectors.toUnmodifiableList()));

        assertThat(bishop.getValidMovePositions()).containsExactlyInAnyOrderElementsOf(expectedPositions);
    }

}
