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
        assertAll(() -> verifyPiece(Piece.createWhitePawn(), WHITE, Type.PAWN, Piece.WHITE_PAWN),
                  () -> verifyPiece(Piece.createBlackPawn(), BLACK, Type.PAWN, Piece.BLACK_PAWN),
                  () -> verifyPiece(Piece.createWhiteKnight(), WHITE, Type.KNIGHT, Piece.WHITE_KNIGHT),
                  () -> verifyPiece(Piece.createBlackKnight(), BLACK, Type.KNIGHT, Piece.BLACK_KNIGHT),
                  () -> verifyPiece(Piece.createWhiteRook(), WHITE, Type.ROOK, Piece.WHITE_ROOK),
                  () -> verifyPiece(Piece.createBlackRook(), BLACK, Type.ROOK, Piece.BLACK_ROOK),
                  () -> verifyPiece(Piece.createWhiteBishop(), WHITE, Type.BISHOP, Piece.WHITE_BISHOP),
                  () -> verifyPiece(Piece.createBlackBishop(), BLACK, Type.BISHOP, Piece.BLACK_BISHOP),
                  () -> verifyPiece(Piece.createWhiteKing(), WHITE, Type.KING, Piece.WHITE_KING),
                  () -> verifyPiece(Piece.createBlackKing(), BLACK, Type.KING, Piece.BLACK_KING),
                  () -> verifyPiece(Piece.createWhiteQueen(), WHITE, Type.QUEEN, Piece.WHITE_QUEEN),
                  () -> verifyPiece(Piece.createBlackQueen(), BLACK, Type.QUEEN, Piece.BLACK_QUEEN));
    }

    void verifyPiece(final Piece piece, final Piece.Color color, final Type type, final String representation) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                  () -> assertThat(piece.getType()).isEqualTo(type),
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
