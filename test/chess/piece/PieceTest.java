package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.BISHOP;
import static chess.piece.Type.KING;
import static chess.piece.Type.KNIGHT;
import static chess.piece.Type.PAWN;
import static chess.piece.Type.QUEEN;
import static chess.piece.Type.ROOK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("create: 모든 말을 정상적으로 생성한다")
    public void create() {
        Position position = new Position("a1");

        assertAll(() -> verifyPiece(Pawn.createWhite(position), WHITE, PAWN),
                  () -> verifyPiece(Pawn.createBlack(position), BLACK, PAWN),
                  () -> verifyPiece(Knight.createWhite(position), WHITE, KNIGHT),
                  () -> verifyPiece(Knight.createBlack(position), BLACK, KNIGHT),
                  () -> verifyPiece(Rook.createWhite(position), WHITE, ROOK),
                  () -> verifyPiece(Rook.createBlack(position), BLACK, ROOK),
                  () -> verifyPiece(Bishop.createWhite(position), WHITE, BISHOP),
                  () -> verifyPiece(Bishop.createBlack(position), BLACK, BISHOP),
                  () -> verifyPiece(King.createWhite(position), WHITE, KING),
                  () -> verifyPiece(King.createBlack(position), BLACK, KING),
                  () -> verifyPiece(Queen.createWhite(position), WHITE, QUEEN),
                  () -> verifyPiece(Queen.createBlack(position), BLACK, QUEEN));
    }

    void verifyPiece(final Piece piece, final Color color, final Type type) {
        assertAll(() -> assertThat(piece.isColor(color)).isTrue(),
                  () -> assertThat(piece.isType(type)).isTrue());
    }

    @Test
    @DisplayName("isColor: 검은색 기물과 흰색 기물을 구분할 수 있다")
    public void checkColor() {
        Position position = new Position("a1");

        final Piece blackBishop = Bishop.createBlack(position);
        final Piece whiteBishop = Bishop.createWhite(position);

        assertAll(() -> assertThat(blackBishop.isColor(BLACK)).isTrue(),
                  () -> assertThat(blackBishop.isColor(WHITE)).isFalse(),
                  () -> assertThat(whiteBishop.isColor(WHITE)).isTrue(),
                  () -> assertThat(whiteBishop.isColor(BLACK)).isFalse());
    }

    @Test
    @DisplayName("흰색 기물은 소문자로 검은색 기물은 대문자로 표현한다")
    public void checkRepresentationPerPiece() {
        Position position = new Position("a1");

        assertAll(() -> assertThat(Knight.createWhite(position).getRepresentation()).isEqualTo("n"),
                  () -> assertThat(Knight.createBlack(position).getRepresentation()).isEqualTo("N"));
    }

}
