package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhitePawnTest {

    @DisplayName("인증 할 color가 white이면 ture를 반환한다")
    @Test
    void verifyPawn() {
        WhitePawn whitePawn = new WhitePawn();
        assertThat(whitePawn.verifyColor(Color.WHITE)).isTrue();
        assertThat(whitePawn.verifyColor(Color.BLACK)).isFalse();
    }

    @DisplayName("PawnRepresentation.WHITE_PAWN 를 return")
    @Test
    void getRepresentation() {
        WhitePawn whitePawn = new WhitePawn();

        assertThat(whitePawn.getRepresentation()).isEqualTo(Representation.WHITE_PAWN.getValue());
    }

    @DisplayName("다른 기물을 잡아 먹지 않을 때 WhitePawn의 위로 2칸 이동 가능하다")
    @Test
    void getCanMove() {
        Board board = new Board();
        board.initialize();
        WhitePawn whitePawn = new WhitePawn();
        assertThat(whitePawn.getCanMovePositions(Position.parse("a1"), board)).isEmpty();

        assertThat(whitePawn.getCanMovePositions(Position.parse("b2"), board)).containsOnly(
                Position.parse("b3"),
                Position.parse("b4")
        );

        assertThat(whitePawn.getCanMovePositions(Position.parse("b5"), board)).containsOnly(
                Position.parse("b6"),
                Position.parse("b7")
        );

        assertThat(whitePawn.getCanMovePositions(Position.parse("b6"), board)).containsOnly(
                Position.parse("b7")
        );
    }

    @DisplayName("다른 기물을 잡아 먹었으면 WhitePawn의 위로 대각선 이동 가능하다")
    @Test
    void getCanMoveIsCapture() {
        Board board = new Board();
        board.initialize();
        WhitePawn whitePawn = new WhitePawn();
        whitePawn.capturePiece();
        assertThat(whitePawn.getCanMovePositions(Position.parse("a1"), board)).isEmpty();

        assertThat(whitePawn.getCanMovePositions(Position.parse("a2"), board)).containsOnly(
                Position.parse("b3")
        );

        assertThat(whitePawn.getCanMovePositions(Position.parse("b6"), board)).containsOnly(
                Position.parse("a7"),
                Position.parse("c7")
        );
    }
}
