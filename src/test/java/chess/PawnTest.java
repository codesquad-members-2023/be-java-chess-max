package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.color.Color;

public class PawnTest {

	@Test
	@DisplayName("지정한 색의 폰이 생성되어야 한다.")
	void create() {
		//given
		Pawn whitePawn = new Pawn(Color.WHITE);
		Pawn blackPawn = new Pawn(Color.BLACK);

		//when, then
		Assertions.assertAll(
			() -> assertThat(whitePawn.getColor()).isEqualTo(Color.WHITE),
			() -> assertThat(blackPawn.getColor()).isEqualTo(Color.BLACK)
		);
	}
}
