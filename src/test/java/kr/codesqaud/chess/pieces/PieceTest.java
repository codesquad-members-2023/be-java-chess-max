package kr.codesqaud.chess.pieces;


import static kr.codesqaud.chessgame.pieces.Piece.*;
import static kr.codesqaud.chessgame.pieces.Piece.Type.*;

import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Piece.Color;
import kr.codesqaud.chessgame.pieces.Piece.Type;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.sql.init.dependency.AbstractBeansOfTypeDatabaseInitializerDetector;

class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(createWhitePawn(), Color.WHITE, PAWN.getWhiteRepresentation());
        verifyPawn(createBlackPawn(), Color.BLACK, PAWN.getBlackRepresentation());
    }

    @Test
    @DisplayName("폰의 색깔이 백색이어야 한다.")
    public void isWhite() {
        // given
        final Piece whitePawn = createWhitePawn();
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
        final Piece whitePawn = createBlackPawn();
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

    @Test
    @DisplayName("팩토리 메소드로 생성한 기물 객체는 색상과 타입이 일치하여야 한다")
    public void create_piece() {
        // when
        Piece whitePawn = createWhitePawn();
        Piece blackPawn = createBlackPawn();
        Piece whiteRook = createWhiteRook();
        Piece blackRook = createBlackRook();
        Piece whiteKnight = createWhiteKnight();
        Piece blackKnight = createBlackKnight();
        Piece whiteBishop = createWhiteBishop();
        Piece blackBishop = createBlackBishop();
        Piece whiteQueen = createWhiteQueen();
        Piece blackQueen = createBlackQueen();
        Piece whiteKing = createWhiteKing();
        Piece blackKing = createBlackKing();
        // then
        verifyPiece(whitePawn, blackPawn, PAWN);
        verifyPiece(whiteRook, blackRook, ROOK);
        verifyPiece(whiteKnight, blackKnight, KNIGHT);
        verifyPiece(whiteBishop, blackBishop, BISHOP);
        verifyPiece(whiteQueen, blackQueen, QUEEN);
        verifyPiece(whiteKing, blackKing, KING);
    }

    private void verifyPawn(final Piece piece, final Color color, final String representation) {
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(piece.getColor()).isEqualTo(color);
        assertions.assertThat(piece.getRepresentation()).isEqualTo(representation);
        assertions.assertAll();
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(whitePiece.isWhite()).isTrue();
        assertions.assertThat(whitePiece.getType()).isEqualTo(type);
        assertions.assertThat(blackPiece.isBlack()).isTrue();
        assertions.assertThat(blackPiece.getType()).isEqualTo(type);
        assertions.assertAll();
    }

}
