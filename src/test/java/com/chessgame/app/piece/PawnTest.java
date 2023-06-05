package com.chessgame.app.piece;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

	@DisplayName("원하는 색의 Pawn을 생성할 수 있다.")
	@Test
	void create() {
		Pawn whitePawn = new Pawn(PieceColor.WHITE);
		Pawn balckPawn = new Pawn(PieceColor.BLACK);

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(whitePawn.verifyColor(PieceColor.WHITE)).isTrue();
		softAssertions.assertThat(balckPawn.verifyColor(PieceColor.BLACK)).isTrue();
		softAssertions.assertAll();
	}

	@DisplayName("Pawn 생성시 색을 지정하지 않으면 흰색 Pawn이 생성된다")
	@Test
	void create_default_constructor() {
		Pawn pawn = new Pawn();

		assertThat(pawn.verifyColor(PieceColor.WHITE)).isTrue();
	}

}
