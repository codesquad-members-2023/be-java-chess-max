package kr.codesqaud.chess.pieces;


import static kr.codesqaud.chessgame.pieces.Piece.Type.*;

import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Piece.Color;
import kr.codesqaud.chessgame.pieces.Piece.Type;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.createWhitePawn(), Color.WHITE, PAWN.getWhiteRepresentation());
        verifyPawn(Piece.createBlackPawn(), Color.BLACK, PAWN.getBlackRepresentation());
    }

    @Test
    @DisplayName("폰의 색깔이 백색이어야 한다.")
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
    @DisplayName("폰의 색깔이 흑색이어야 한다.")
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


    @Test
    @DisplayName("백색폰은 소문자 p이고 흑색폰은 대문자 P여야 한다")
    public void getRepresentationPerPiece() {
        // given
        Type pawn = PAWN;
        // when
        String whiteRepresentation = pawn.getWhiteRepresentation();
        String blackRepresentation = pawn.getBlackRepresentation();
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(whiteRepresentation).isEqualTo("p");
        assertions.assertThat(blackRepresentation).isEqualTo("P");
        assertions.assertAll();
    }

    private void verifyPawn(final Piece piece, final Color color, final String representation) {
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(piece.getColor()).isEqualTo(color);
        assertions.assertThat(piece.getRepresentation()).isEqualTo(representation);
        assertions.assertAll();
    }

}
