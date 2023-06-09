package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static chess.pieces.Pawn.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

	@Test
	@DisplayName("지정한 색의 폰이 생성되어야 한다.")
	public void create() {
		verifyPawn(WHITE_COLOR, WHITE_REPRESENTATION);
		verifyPawn(BLACK_COLOR, BLACK_REPRESENTATION);
	}

	@Test
	@DisplayName("폰의 기본 생성자 색깔은 흰색이다.")
	public void createPawn() {
		Pawn pawn = new Pawn();
		assertThat(pawn.getColor()).isEqualTo(WHITE_COLOR);
		assertThat(pawn.getRepresentation()).isEqualTo(WHITE_REPRESENTATION);
	}

	private void verifyPawn(String color, char representation) {
		Pawn pawn = new Pawn(color, representation);
		assertThat(pawn.getColor()).isEqualTo(color);
		assertThat(pawn.getRepresentation()).isEqualTo(representation);
	}
}
