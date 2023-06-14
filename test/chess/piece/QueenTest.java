package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static chess.util.StringUtil.BOARD_END_INDEX;
import static chess.util.StringUtil.BOARD_START_INDEX;
import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 퀸이 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositions() {
        final Position queenPosition = new Position("d3");
        Queen queen = Queen.createBlack(queenPosition);

        Set<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position("d2"));
        expectedPositions.add(new Position("d4"));
        expectedPositions.add(new Position("c2"));
        expectedPositions.add(new Position("c3"));
        expectedPositions.add(new Position("c4"));
        expectedPositions.add(new Position("e2"));
        expectedPositions.add(new Position("e3"));
        expectedPositions.add(new Position("e4"));

        for (int i = BOARD_START_INDEX; i <= BOARD_END_INDEX; i++) {
            expectedPositions.add(new Position(queenPosition.getIndexX() - i, queenPosition.getIndexY() - i));
            expectedPositions.add(new Position(queenPosition.getIndexX() - i, queenPosition.getIndexY() + i));
            expectedPositions.add(new Position(queenPosition.getIndexX() + i, queenPosition.getIndexY() - i));
            expectedPositions.add(new Position(queenPosition.getIndexX() + i, queenPosition.getIndexY() + i));
            expectedPositions.add(new Position(queenPosition.getIndexX(), i));
            expectedPositions.add(new Position(i, queenPosition.getIndexY()));
        }

        final List<Position> positions = expectedPositions.stream().filter(p -> p.isValidBoardPosition() && !p.equals(queenPosition)).collect(Collectors.toUnmodifiableList());

        assertThat(queen.getValidMovePositions()).containsExactlyInAnyOrderElementsOf(positions);
    }

}
