package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static chess.pieces.Piece.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

	@Test
	@DisplayName("지정한 색의 말이 생성되어야 한다.")
	public void create() {
		verifyPiece(Piece.createWhitePawn(), WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
		verifyPiece(Piece.createBlackPawn(), BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
		verifyPiece(Piece.createWhiteKnight(), WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
		verifyPiece(Piece.createBlackKnight(), BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
		verifyPiece(Piece.createWhiteRook(), WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
		verifyPiece(Piece.createBlackRook(), BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
		verifyPiece(Piece.createWhiteBishop(), WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
		verifyPiece(Piece.createBlackBishop(), BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
		verifyPiece(Piece.createWhiteQueen(), WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
		verifyPiece(Piece.createBlackQueen(), BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
		verifyPiece(Piece.createWhiteKing(), WHITE_COLOR, WHITE_KING_REPRESENTATION);
		verifyPiece(Piece.createBlackKing(), BLACK_COLOR, BLACK_KING_REPRESENTATION);
	}

	private void verifyPiece(Piece piece, String color, char representation) {
		assertThat(piece.getColor()).isEqualTo(color);
		assertThat(piece.getRepresentation()).isEqualTo(representation);
	}

	@Test
	@DisplayName("말의 색을 구분할 수 있다.")
	public void checkColor() {
		assertThat(Piece.createWhitePawn().isWhite()).isTrue();
		assertThat(Piece.createWhiteBishop().isWhite()).isTrue();
		assertThat(Piece.createBlackKnight().isBlack()).isTrue();
		assertThat(Piece.createBlackQueen().isBlack()).isTrue();
	}
}
