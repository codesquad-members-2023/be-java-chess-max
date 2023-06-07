package chess.piece;

import chess.Color;
import chess.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("create: 팩토리 메서드를 사용하여 모든 말을 정상적으로 생성한다")
    public void create() {
        assertAll(() -> verifyPiece(Piece.createWhitePawn(), WHITE, Name.PAWN, Piece.WHITE_PAWN),
                  () -> verifyPiece(Piece.createBlackPawn(), BLACK, Name.PAWN, Piece.BLACK_PAWN),
                  () -> verifyPiece(Piece.createWhiteKnight(), WHITE, Name.KNIGHT, Piece.WHITE_KNIGHT),
                  () -> verifyPiece(Piece.createBlackKnight(), BLACK, Name.KNIGHT, Piece.BLACK_KNIGHT),
                  () -> verifyPiece(Piece.createWhiteRook(), WHITE, Name.ROOK, Piece.WHITE_ROOK),
                  () -> verifyPiece(Piece.createBlackRook(), BLACK, Name.ROOK, Piece.BLACK_ROOK),
                  () -> verifyPiece(Piece.createWhiteBishop(), WHITE, Name.BISHOP, Piece.WHITE_BISHOP),
                  () -> verifyPiece(Piece.createBlackBishop(), BLACK, Name.BISHOP, Piece.BLACK_BISHOP),
                  () -> verifyPiece(Piece.createWhiteKing(), WHITE, Name.KING, Piece.WHITE_KING),
                  () -> verifyPiece(Piece.createBlackKing(), BLACK, Name.KING, Piece.BLACK_KING),
                  () -> verifyPiece(Piece.createWhiteQueen(), WHITE, Name.QUEEN, Piece.WHITE_QUEEN),
                  () -> verifyPiece(Piece.createBlackQueen(), BLACK, Name.QUEEN, Piece.BLACK_QUEEN));
    }

    void verifyPiece(final Piece piece, final Color color, final Name name, final String representation) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                  () -> assertThat(piece.getName()).isEqualTo(name),
                  () -> assertThat(piece.getRepresentation()).isEqualTo(representation));
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

}
