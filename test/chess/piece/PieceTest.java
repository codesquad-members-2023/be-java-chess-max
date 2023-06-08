package chess.piece;

import chess.piece.Piece.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.piece.Piece.Color.BLACK;
import static chess.piece.Piece.Color.WHITE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("create: 팩토리 메서드를 사용하여 모든 말을 정상적으로 생성한다")
    public void create() {
        assertAll(() -> verifyPiece(Piece.createWhitePawn(), WHITE, Type.PAWN),
                  () -> verifyPiece(Piece.createBlackPawn(), BLACK, Type.PAWN),
                  () -> verifyPiece(Piece.createWhiteKnight(), WHITE, Type.KNIGHT),
                  () -> verifyPiece(Piece.createBlackKnight(), BLACK, Type.KNIGHT),
                  () -> verifyPiece(Piece.createWhiteRook(), WHITE, Type.ROOK),
                  () -> verifyPiece(Piece.createBlackRook(), BLACK, Type.ROOK),
                  () -> verifyPiece(Piece.createWhiteBishop(), WHITE, Type.BISHOP),
                  () -> verifyPiece(Piece.createBlackBishop(), BLACK, Type.BISHOP),
                  () -> verifyPiece(Piece.createWhiteKing(), WHITE, Type.KING),
                  () -> verifyPiece(Piece.createBlackKing(), BLACK, Type.KING),
                  () -> verifyPiece(Piece.createWhiteQueen(), WHITE, Type.QUEEN),
                  () -> verifyPiece(Piece.createBlackQueen(), BLACK, Type.QUEEN));
    }

    void verifyPiece(final Piece piece, final Piece.Color color, final Type type) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                  () -> assertThat(piece.getType()).isEqualTo(type));
    }

    @Test
    @DisplayName("isWhite / isBlack: 검은색 기물과 흰색 기물을 구분할 수 있다")
    public void checkColor() {
        final Piece blackBishop = Piece.createBlackBishop();
        final Piece whiteBishop = Piece.createWhiteBishop();

        assertAll(() -> assertThat(blackBishop.isBlack()).isTrue(),
                  () -> assertThat(blackBishop.isWhite()).isFalse(),
                  () -> assertThat(whiteBishop.isWhite()).isTrue(),
                  () -> assertThat(whiteBishop.isBlack()).isFalse());
    }

    @Test
    @DisplayName("흰색 기물은 소문자로 검은색 기물은 대문자로 표현한다")
    public void checkRepresentationPerPiece() {
        assertAll(() -> assertThat(Piece.createWhiteKnight().getRepresentation()).isEqualTo("n"),
                  () -> assertThat(Piece.createBlackKnight().getRepresentation()).isEqualTo("N"));
    }

    @Test
    @DisplayName("팩토리 메서드를 사용하여 색과 종류가 다른 각각의 Piece를 생성한다")
    public void createPiece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        assertAll(() -> assertThat(blank.isWhite()).isFalse(),
                  () -> assertThat(blank.isBlack()).isFalse(),
                  () -> assertThat(blank.getRepresentation()).isEqualTo("."),
                  () -> assertThat(blank.getType()).isEqualTo(Type.BLANK));
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertAll(() -> assertThat(whitePiece.isWhite()).isTrue(),
                  () -> assertThat(blackPiece.isBlack()).isTrue(),
                  () -> assertThat(whitePiece.getType()).isEqualTo(type),
                  () -> assertThat(blackPiece.getType()).isEqualTo(type));
    }

}
