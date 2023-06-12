package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static chess.pieces.Piece.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

	@Test
	@DisplayName("검은색 말은 대문자로 표시되어야 한다.")
	public void getRepresentationPerPiece() throws Exception {
		assertThat('p').isEqualTo(Type.PAWN.getWhiteRepresentation());
		assertThat('P').isEqualTo(Type.PAWN.getBlackRepresentation());
	}

	@Test
	@DisplayName("지정한 색의 말이 생성되어야 한다.")
	public void create() {
		verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN);
		verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN);
		verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT);
		verifyPiece(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT);
		verifyPiece(Piece.createWhiteRook(), Color.WHITE, Type.ROOK);
		verifyPiece(Piece.createBlackRook(), Color.BLACK, Type.ROOK);
		verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP);
		verifyPiece(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP);
		verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN);
		verifyPiece(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN);
		verifyPiece(Piece.createWhiteKing(), Color.WHITE, Type.KING);
		verifyPiece(Piece.createBlackKing(), Color.BLACK, Type.KING);
	}

	private void verifyPiece(Piece piece, Color color, Type representation) {
		assertThat(piece.getColor()).isEqualTo(color);
		assertThat(piece.getRepresentation()).isEqualTo(representation);
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
