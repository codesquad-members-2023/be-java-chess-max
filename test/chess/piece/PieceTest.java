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
        Position position = new Position("a1");

        assertAll(() -> verifyPiece(Piece.createWhitePawn(position), WHITE, Type.PAWN),
                  () -> verifyPiece(Piece.createBlackPawn(position), BLACK, Type.PAWN),
                  () -> verifyPiece(Piece.createWhiteKnight(position), WHITE, Type.KNIGHT),
                  () -> verifyPiece(Piece.createBlackKnight(position), BLACK, Type.KNIGHT),
                  () -> verifyPiece(Piece.createWhiteRook(position), WHITE, Type.ROOK),
                  () -> verifyPiece(Piece.createBlackRook(position), BLACK, Type.ROOK),
                  () -> verifyPiece(Piece.createWhiteBishop(position), WHITE, Type.BISHOP),
                  () -> verifyPiece(Piece.createBlackBishop(position), BLACK, Type.BISHOP),
                  () -> verifyPiece(Piece.createWhiteKing(position), WHITE, Type.KING),
                  () -> verifyPiece(Piece.createBlackKing(position), BLACK, Type.KING),
                  () -> verifyPiece(Piece.createWhiteQueen(position), WHITE, Type.QUEEN),
                  () -> verifyPiece(Piece.createBlackQueen(position), BLACK, Type.QUEEN));
    }

    void verifyPiece(final Piece piece, final Piece.Color color, final Type type) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                  () -> assertThat(piece.getType()).isEqualTo(type));
    }

    @Test
    @DisplayName("isWhite / isBlack: 검은색 기물과 흰색 기물을 구분할 수 있다")
    public void checkColor() {
        Position position = new Position("a1");

        final Piece blackBishop = Piece.createBlackBishop(position);
        final Piece whiteBishop = Piece.createWhiteBishop(position);

        assertAll(() -> assertThat(blackBishop.isBlack()).isTrue(),
                  () -> assertThat(blackBishop.isWhite()).isFalse(),
                  () -> assertThat(whiteBishop.isWhite()).isTrue(),
                  () -> assertThat(whiteBishop.isBlack()).isFalse());
    }

    @Test
    @DisplayName("흰색 기물은 소문자로 검은색 기물은 대문자로 표현한다")
    public void checkRepresentationPerPiece() {
        Position position = new Position("a1");

        assertAll(() -> assertThat(Piece.createWhiteKnight(position).getRepresentation()).isEqualTo("n"),
                  () -> assertThat(Piece.createBlackKnight(position).getRepresentation()).isEqualTo("N"));
    }

    @Test
    @DisplayName("팩토리 메서드를 사용하여 색과 종류가 다른 각각의 Piece를 생성한다")
    public void createPiece() {
        Position position = new Position("a1");

        verifyPiece(Piece.createWhitePawn(position), Piece.createBlackPawn(position), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(position), Piece.createBlackKnight(position), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(position), Piece.createBlackRook(position), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(position), Piece.createBlackBishop(position), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(position), Piece.createBlackQueen(position), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(position), Piece.createBlackKing(position), Type.KING);

        Piece blank = Piece.createBlank(position);
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
