package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static chess.pieces.Pawn.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

	@Test
	@DisplayName("지정한 색의 폰이 생성되어야 한다.")
	public void create() {
		verifyPawn(WHITE_COLOR);
		verifyPawn(BLACK_COLOR);
	}

	@Test
	@DisplayName("폰의 기본 생성자 색깔은 흰색이다.")
	public void createPawn() {
		chess.pieces.Pawn pawn = new chess.pieces.Pawn();
		assertThat(pawn.getColor()).isEqualTo(WHITE_COLOR);
	}

	private void verifyPawn(String color) {
		chess.pieces.Pawn pawn = new chess.pieces.Pawn(color);
		assertThat(pawn.getColor()).isEqualTo(color);
	}
}
