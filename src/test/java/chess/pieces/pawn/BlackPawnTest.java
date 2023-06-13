package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackPawnTest {

    @DisplayName("인증 할 color가 Black일 때만 ture를 반환한다")
    @Test
    void verifyPawn() {
        BlackPawn blackPawn = new BlackPawn();
        assertThat(blackPawn.verifyColor(Color.BLACK)).isTrue();
        assertThat(blackPawn.verifyColor(Color.WHITE)).isFalse();
    }

    @DisplayName("PawnRepresentation.BLACK_PAWN 를 return")
    @Test
    void getRepresentation() {
        BlackPawn blackPawn = new BlackPawn();
        assertThat(blackPawn.getRepresentation()).isEqualTo(Representation.BLACK_PAWN.getValue());
    }

    @DisplayName("다른 기물을 잡아 먹지 않을 때 BlackPawn의 아래로 2칸 이동 가능하다")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        BlackPawn blackPawn = new BlackPawn();
        assertThat(blackPawn.getCanMovePositions(Position.parse("a8"), board)).isEmpty();

        assertThat(blackPawn.getCanMovePositions(Position.parse("a7"), board)).containsOnly(
                Position.parse("a6"),
                Position.parse("a5")
        );

        assertThat(blackPawn.getCanMovePositions(Position.parse("a4"), board)).containsOnly(
                Position.parse("a3"),
                Position.parse("a2")
        );

        assertThat(blackPawn.getCanMovePositions(Position.parse("a3"), board)).containsOnly(
                Position.parse("a2")
        );
    }

    @DisplayName("다른 기물을 잡아 먹었으면 BlackPawn의 아래로 대각선 이동 가능하다")
    @Test
    void getCanMoveIsCapture() {
        Board board = new Board();
        board.initialize();
        BlackPawn blackPawn = new BlackPawn();
        blackPawn.capturePiece();
        assertThat(blackPawn.getCanMovePositions(Position.parse("a8"), board)).isEmpty();

        assertThat(blackPawn.getCanMovePositions(Position.parse("a7"), board)).containsOnly(
                Position.parse("b6")
        );

        assertThat(blackPawn.getCanMovePositions(Position.parse("b4"), board)).containsOnly(
                Position.parse("a3"),
                Position.parse("c3")
        );

        assertThat(blackPawn.getCanMovePositions(Position.parse("b3"), board)).containsOnly(
                Position.parse("a2"),
                Position.parse("c2")
        );
    }
}
