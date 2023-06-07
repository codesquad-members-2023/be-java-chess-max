package kr.codesqaud.chess.pieces;


import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Piece;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.createWhitePawn(), Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.createBlackPawn(), Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("폰의 색깔이 하얀색이어야 한다.")
    public void isWhite() {
        // given
        final Piece whitePawn = Piece.createWhitePawn();
        // when
        final boolean white = whitePawn.isWhite();
        // then
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(white).isTrue();
        assertions.assertAll();
    }

    @Test
    @DisplayName("폰의 색깔이 검색이어야 한다.")
    public void isBlack() {
        // given
        final Piece whitePawn = Piece.createBlackPawn();
        // when
        final boolean black = whitePawn.isBlack();
        // then
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(black).isTrue();
        assertions.assertAll();
    }

    private void verifyPawn(final Piece piece, final Color color, final String representation) {
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(piece.getColor()).isEqualTo(color);
        assertions.assertThat(piece.getRepresentation()).isEqualTo(representation);
        assertions.assertAll();
    }
}
