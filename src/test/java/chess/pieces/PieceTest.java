package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static chess.pieces.Piece.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

	@Test
	@DisplayName("검은색 말은 대문자로 표시되어야 한다.")
	public void getRepresentationPerPiece() {
		assertThat('p').isEqualTo(Type.PAWN.getWhiteRepresentation());
		assertThat('P').isEqualTo(Type.PAWN.getBlackRepresentation());
	}

	@Test
	@DisplayName("지정한 색의 말이 생성되어야 한다.")
	public void create() {
		verifyPiece(Type.PAWN);
		verifyPiece(Type.KNIGHT);
		verifyPiece(Type.ROOK);
		verifyPiece(Type.BISHOP);
		verifyPiece(Type.QUEEN);
		verifyPiece(Type.KING);

		Piece blank = Piece.createBlank();
		assertThat(blank.isWhite()).isFalse();
		assertThat(blank.isBlack()).isFalse();
		assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
	}

	private void verifyPiece(Type type) {
		Piece whitePiece = createWhite(type);
		assertThat(whitePiece.isWhite()).isTrue();
		assertThat(whitePiece.getType()).isEqualTo(type);

		Piece blackPiece = createBlack(type);
		assertThat(blackPiece.isBlack()).isTrue();
		assertThat(blackPiece.getType()).isEqualTo(type);
	}

	@Test
	@DisplayName("말의 색을 구분할 수 있다.")
	public void checkColor() {
		assertThat(Piece.createWhite(Type.PAWN).isWhite()).isTrue();
		assertThat(Piece.createWhite(Type.ROOK).isWhite()).isTrue();
		assertThat(Piece.createWhite(Type.BISHOP).isWhite()).isTrue();
		assertThat(Piece.createWhite(Type.KNIGHT).isWhite()).isTrue();
		assertThat(Piece.createWhite(Type.QUEEN).isWhite()).isTrue();
		assertThat(Piece.createWhite(Type.KING).isWhite()).isTrue();
		assertThat(Piece.createBlack(Type.PAWN).isBlack()).isTrue();
		assertThat(Piece.createBlack(Type.ROOK).isBlack()).isTrue();
		assertThat(Piece.createBlack(Type.BISHOP).isBlack()).isTrue();
		assertThat(Piece.createBlack(Type.KNIGHT).isBlack()).isTrue();
		assertThat(Piece.createBlack(Type.QUEEN).isBlack()).isTrue();
		assertThat(Piece.createBlack(Type.KING).isBlack()).isTrue();
	}
}
