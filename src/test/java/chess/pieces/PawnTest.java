package chess.pieces;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import chess.color.Color;

class PawnTest {

	@EnumSource(Color.class)
	@ParameterizedTest
	@DisplayName("지정한 색의 폰이 생성되어야 한다.")
	void create(Color color) {
		//given
		Pawn pawn = new Pawn(color);

		//when, then
		assertThat(pawn.getColor()).isEqualTo(color);
	}
}
