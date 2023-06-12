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
		verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
		verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
		verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
		verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
		verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
		verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

		Piece blank = Piece.createBlank();
		assertThat(blank.isWhite()).isFalse();
		assertThat(blank.isBlack()).isFalse();
		assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
	}

	private void verifyPiece(Piece whitePiece, Piece blackPiece, Type type) {
		assertThat(whitePiece.isWhite()).isTrue();
		assertThat(whitePiece.getType()).isEqualTo(type);

		assertThat(blackPiece.isBlack()).isTrue();
		assertThat(blackPiece.getType()).isEqualTo(type);
	}

	@Test
	@DisplayName("말의 색을 구분할 수 있다.")
	public void checkColor() {
		assertThat(Piece.createWhitePawn().isWhite()).isTrue();
		assertThat(Piece.createWhiteRook().isWhite()).isTrue();
		assertThat(Piece.createWhiteBishop().isWhite()).isTrue();
		assertThat(Piece.createWhiteKnight().isWhite()).isTrue();
		assertThat(Piece.createWhiteQueen().isWhite()).isTrue();
		assertThat(Piece.createWhiteKing().isWhite()).isTrue();
		assertThat(Piece.createBlackPawn().isBlack()).isTrue();
		assertThat(Piece.createBlackRook().isBlack()).isTrue();
		assertThat(Piece.createBlackBishop().isBlack()).isTrue();
		assertThat(Piece.createBlackKnight().isBlack()).isTrue();
		assertThat(Piece.createBlackQueen().isBlack()).isTrue();
		assertThat(Piece.createBlackKing().isBlack()).isTrue();
	}
}
