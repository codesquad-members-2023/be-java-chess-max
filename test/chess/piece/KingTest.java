package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.KING;
import static chess.piece.Type.PAWN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class KingTest {

    @Test
    @DisplayName("create: 지정한 위치에 검은색 킹과 흰색 킹을 생성한다")
    public void create() {
        Position position = new Position("a1");

        final King black = King.createBlack(position);
        final King white = King.createWhite(position);

        assertAll(() -> assertThat(black.getPosition()).isEqualTo(position),
                  () -> assertThat(black.getRepresentation()).isEqualTo("K"),
                  () -> assertThat(black.isType(KING)).isTrue(),
                  () -> assertThat(black.isColor(BLACK)).isTrue(),
                  () -> assertThat(black.isType(PAWN)).isFalse(),
                  () -> assertThat(black.isColor(WHITE)).isFalse(),

                  () -> assertThat(white.getPosition()).isEqualTo(position),
                  () -> assertThat(white.getRepresentation()).isEqualTo("k"),
                  () -> assertThat(white.isColor(WHITE)).isTrue(),
                  () -> assertThat(white.isType(KING)).isTrue(),
                  () -> assertThat(white.isType(PAWN)).isFalse(),
                  () -> assertThat(white.isColor(BLACK)).isFalse());
    }

    @Test
    @DisplayName("getValidMovePositions: 주변 기물들을 무시하고 킹이 움직일 수 있는 Position을 반환한다")
    public void getValidMovePositions() {
        King king = King.createWhite(new Position("a1"));
        assertThat(king.getValidMovePositions()).containsExactlyInAnyOrder(new Position("a2"), new Position("b1"));

        king.setPosition(new Position("b1"));
        assertThat(king.getValidMovePositions()).containsExactlyInAnyOrder(new Position("a1"), new Position("b2"), new Position("c1"));
    }

}
