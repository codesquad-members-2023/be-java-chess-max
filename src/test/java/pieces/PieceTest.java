package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.Piece.Color;
import static pieces.Piece.Type;

public class PieceTest {

    @Test
    @DisplayName("흰색 또는 검은색으로 기물이 생성된다.")
    public void create() {
        verifyPiece(Pawn.createWhite(new Position("a1")), Pawn.createBlack(new Position("a8")), Type.PAWN);
        verifyPiece(Knight.createWhite(new Position("a1")), Knight.createBlack(new Position("a8")), Type.KNIGHT);
        verifyPiece(Rook.createWhite(new Position("a1")), Rook.createBlack(new Position("a8")), Type.ROOK);
        verifyPiece(Bishop.createWhite(new Position("a1")), Bishop.createBlack(new Position("a8")), Type.BISHOP);
        verifyPiece(Queen.createWhite(new Position("a1")), Queen.createBlack(new Position("a8")), Type.QUEEN);
        verifyPiece(King.createWhite(new Position("a1")), King.createBlack(new Position("a8")), Type.KING);

        Piece blank = Blank.createBlank(new Position("a1"));
        assertThat(blank.getColor()).isEqualTo(Color.NOCOLOR);
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    public void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("생성한 기물이 흰색인지 검은색인지 확인한다.")
    public void isBlackOrWhite() {
        Piece whitePawn = Pawn.createWhite(new Position("a1"));
        Piece blackPawn = Pawn.createBlack(new Position("a8"));
        Piece whiteKnight = Knight.createWhite(new Position("a1"));
        Piece blackKnight = Knight.createBlack(new Position("a8"));

        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(whiteKnight.isWhite()).isTrue();
        assertThat(blackKnight.isBlack()).isTrue();
    }

}
